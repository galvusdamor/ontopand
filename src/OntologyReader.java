import org.semanticweb.HermiT.Reasoner;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.ConsoleProgressMonitor;
import org.semanticweb.owlapi.reasoner.NullReasonerProgressMonitor;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerConfiguration;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;
import org.semanticweb.owlapi.reasoner.ReasonerProgressMonitor;
import org.semanticweb.owlapi.reasoner.SimpleConfiguration;

import uk.ac.manchester.cs.factplusplus.owlapiv3.FaCTPlusPlusReasonerFactory;
import uk.ac.manchester.cs.jfact.JFactFactory;

public class OntologyReader {

	private OWLDataFactory dataFactory;
	private OWLReasoner reasoner;
	private OWLReasonerFactory factory;

	public OntologyReader(String filename) throws OWLOntologyCreationException {
		// create "manager" instances of OWL API
		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		dataFactory = manager.getOWLDataFactory();

		// adjust path to your location of the cluster 6 ontology.
		java.io.File file = new java.io.File(filename);
		OWLOntology workoutOntology = manager.loadOntologyFromOntologyDocument(file);


		ReasonerProgressMonitor progressMonitor = (Main.commandLineConfig.showReasonerProgress) ? new ConsoleProgressMonitor() : new NullReasonerProgressMonitor();
		OWLReasonerConfiguration configOWL = new SimpleConfiguration(progressMonitor, 10000L);

		switch (Main.commandLineConfig.reasoner) {
		case HermiT:
			factory = new Reasoner.ReasonerFactory();
			break;
		case FACTPP:
			factory = new FaCTPlusPlusReasonerFactory();
			break;
		case JFACT:
			factory = new JFactFactory();
			break;
		}

		reasoner = factory.createReasoner(workoutOntology, configOWL);
		// reasoner.precomputeInferences();

		// print consistency
		boolean consistent = reasoner.isConsistent();
		System.out.println("Workout Ontology is consistent: " + consistent);
		if (!consistent) throw new IllegalArgumentException("Given ontology is not consistent!");
	}

	public OWLDataFactory getDataFactory() {
		return dataFactory;
	}

	public OWLReasoner getReasoner() {
		return reasoner;
	}

	public OWLClass getOWLClass(String base, String clazz) {
		return dataFactory.getOWLClass(IRI.create(base + '#' + clazz));
	}

	public OWLObjectProperty getOWLObjectProperty(String base, String property) {
		return dataFactory.getOWLObjectProperty(IRI.create(base + '#' + property));
	}

	public OWLDataProperty getOWLDataProperty(String base, String property) {
		return dataFactory.getOWLDataProperty(IRI.create(base + '#' + property));
	}

	public OWLReasonerFactory getFactory() {
		return factory;
	}
}
