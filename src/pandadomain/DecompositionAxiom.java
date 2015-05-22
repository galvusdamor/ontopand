//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.17 at 05:46:49 PM CET 
//


package pandadomain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}documentation" minOccurs="0"/>
 *         &lt;element ref="{}variableDeclaration" maxOccurs="unbounded"/>
 *         &lt;element ref="{}leftHandSide"/>
 *         &lt;element ref="{}rightHandSide"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "documentation",
    "variableDeclaration",
    "leftHandSide",
    "rightHandSide"
})
@XmlRootElement(name = "decompositionAxiom")
public class DecompositionAxiom {

    protected String documentation;
    @XmlElement(required = true)
    protected List<VariableDeclaration> variableDeclaration;
    @XmlElement(required = true)
    protected LeftHandSide leftHandSide;
    @XmlElement(required = true)
    protected RightHandSide rightHandSide;
    @XmlAttribute(name = "name", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String name;

    /**
     * Gets the value of the documentation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentation() {
        return documentation;
    }

    /**
     * Sets the value of the documentation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentation(String value) {
        this.documentation = value;
    }

    /**
     * Gets the value of the variableDeclaration property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the variableDeclaration property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVariableDeclaration().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VariableDeclaration }
     * 
     * 
     */
    public List<VariableDeclaration> getVariableDeclaration() {
        if (variableDeclaration == null) {
            variableDeclaration = new ArrayList<VariableDeclaration>();
        }
        return this.variableDeclaration;
    }

    /**
     * Gets the value of the leftHandSide property.
     * 
     * @return
     *     possible object is
     *     {@link LeftHandSide }
     *     
     */
    public LeftHandSide getLeftHandSide() {
        return leftHandSide;
    }

    /**
     * Sets the value of the leftHandSide property.
     * 
     * @param value
     *     allowed object is
     *     {@link LeftHandSide }
     *     
     */
    public void setLeftHandSide(LeftHandSide value) {
        this.leftHandSide = value;
    }

    /**
     * Gets the value of the rightHandSide property.
     * 
     * @return
     *     possible object is
     *     {@link RightHandSide }
     *     
     */
    public RightHandSide getRightHandSide() {
        return rightHandSide;
    }

    /**
     * Sets the value of the rightHandSide property.
     * 
     * @param value
     *     allowed object is
     *     {@link RightHandSide }
     *     
     */
    public void setRightHandSide(RightHandSide value) {
        this.rightHandSide = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

}