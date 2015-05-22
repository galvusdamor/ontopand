import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.nio.charset.Charset;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.reasoner.Node;

import pandadomain.Domain;
import pandadomain.ObjectFactory;

public class Main {

	private static final String VERSION = "v1.1";

	// ////////////////////////////////////////////////////////////////
	public static final String OWLLOCALBASENAME = "http://www.semanticweb.org/dennis/ontologies/2013/9/complete-ontology-20";
	public static final String OWLOPEBASENAME = "http://www.semanticweb.org/ontologies/2013/2/OPE.owl";
	public static final String OWLNCICBBASENAME = "http://ncicb.nci.nih.gov/xml/owl/EVS/Thesaurus.owl";

	// ////////////////////////////////////////////////////////////////
	private static OntologyReader ontology;

	// ////////////////////////////////////////////////////////////////
	// the global command line config
	public static CommandLineConfig commandLineConfig = new CommandLineConfig();

	public static class CommandLineConfig {
		public boolean showReasonerProgress = false;
		public Reasoner reasoner = Reasoner.HermiT;

		public static enum Reasoner {
			HermiT, FACTPP, JFACT
		}
	}

	// ////////////////////////////////////////////////////////////////
	// hack but it is not important which kinds of exceptions this might throw
	public static void main(String[] args) throws Throwable {

		long startTime = System.currentTimeMillis();

		// System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(new File("/home/gregor/ontopand.prtkll")))));

		System.setProperty("java.library.path", ".");
		Field fieldSysPath = ClassLoader.class.getDeclaredField("sys_paths");
		fieldSysPath.setAccessible(true);
		fieldSysPath.set(null, null);

		System.out.println("This is OntoPAND " + VERSION + " written by Gregor Behnke (gregor.behnke@uni-ulm.de)");

		String ontologyFilename = null;
		String targetFilename = null;

		// read command line arguments
		for (int i = 0; i < args.length; i++)
			switch (args[i]) {
			case "--reasonerprogress":
				commandLineConfig.showReasonerProgress = true;
				break;
			case "--HermiT":
				commandLineConfig.reasoner = CommandLineConfig.Reasoner.HermiT;
				break;
			case "--Fact++":
				commandLineConfig.reasoner = CommandLineConfig.Reasoner.FACTPP;
				break;
			case "--JFact":
				commandLineConfig.reasoner = CommandLineConfig.Reasoner.JFACT;
				break;
			default:
				if (ontologyFilename == null) ontologyFilename = args[i];
				else targetFilename = args[i];
				break;
			}

		if (ontologyFilename == null) {
			System.out.println("An ontology must be provided from which a domain model shall be generated.");
			return;
		}

		ontology = new OntologyReader(ontologyFilename);

		// //////////////////////////////////
		// CREATE THE DOMAIN
		// ////////////////////////////////

		// create the domain object
		ObjectFactory objectFactory = new ObjectFactory();
		Domain domain = objectFactory.createDomain();

		// fill the domain
		domain.setName("FitnessDomain");
		domain.setType("pure-hierarchical");

		// // HERE should start the code that transforms the owl file into a domain
		for (Node<OWLClass> exercise : ontology.getReasoner().getSubClasses(ontology.getDataFactory().getOWLThing(), false)) {
			System.out.println(exercise.getRepresentativeElement().getIRI().getFragment());
			System.out.println(exercise.getRepresentativeElement().getIRI());
		}

		// // write Domain to file
		JAXBContext context = JAXBContext.newInstance(Domain.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

		// write the domain description into a "string"
		ByteArrayOutputStream primaryOut = new ByteArrayOutputStream();
		marshaller.marshal(domain, primaryOut);
		String totalDomainString = new String(primaryOut.toByteArray(), Charset.defaultCharset());

		// replace all occurances of 'variableN' by 'variable'. Its introduction was necessary as jaxb deems the PANDA XML schema as incorrect
		File f = new File(targetFilename);
		PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream(f)));
		out.println(totalDomainString.replaceAll("variableN", "variable"));

		out.close();

		// print some statistics
		System.out.println("STATISTICS");
		System.out.println("==========");

		System.out.println("Task schemata: " + domain.getTaskSchemaDeclaration().size());
		System.out.println("Decomposition Methods: " + domain.getMethodDeclaration().size());

		System.out.println("Total Time: " + (System.currentTimeMillis() - startTime) + "ms");

	}
}