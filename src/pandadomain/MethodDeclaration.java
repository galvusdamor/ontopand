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
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
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
 *         &lt;element ref="{}variableDeclaration" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}taskNode" maxOccurs="unbounded"/>
 *         &lt;element ref="{}orderingConstraint" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element ref="{}valueRestriction"/>
 *           &lt;element ref="{}sortRestriction"/>
 *         &lt;/choice>
 *         &lt;element ref="{}causalLink" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="taskSchema" use="required" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
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
    "taskNode",
    "orderingConstraint",
    "valueRestrictionOrSortRestriction",
    "causalLink"
})
@XmlRootElement(name = "methodDeclaration")
public class MethodDeclaration {

    protected String documentation;
    protected List<VariableDeclaration> variableDeclaration;
    @XmlElement(required = true)
    protected List<TaskNode> taskNode;
    protected List<OrderingConstraint> orderingConstraint;
    @XmlElements({
        @XmlElement(name = "valueRestriction", type = ValueRestriction.class),
        @XmlElement(name = "sortRestriction", type = SortRestriction.class)
    })
    protected List<Object> valueRestrictionOrSortRestriction;
    protected List<CausalLink> causalLink;
    @XmlAttribute(name = "name", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String name;
    @XmlAttribute(name = "taskSchema", required = true)
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object taskSchema;

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
     * Gets the value of the taskNode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taskNode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaskNode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TaskNode }
     * 
     * 
     */
    public List<TaskNode> getTaskNode() {
        if (taskNode == null) {
            taskNode = new ArrayList<TaskNode>();
        }
        return this.taskNode;
    }

    /**
     * Gets the value of the orderingConstraint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the orderingConstraint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrderingConstraint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OrderingConstraint }
     * 
     * 
     */
    public List<OrderingConstraint> getOrderingConstraint() {
        if (orderingConstraint == null) {
            orderingConstraint = new ArrayList<OrderingConstraint>();
        }
        return this.orderingConstraint;
    }

    /**
     * Gets the value of the valueRestrictionOrSortRestriction property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the valueRestrictionOrSortRestriction property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValueRestrictionOrSortRestriction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ValueRestriction }
     * {@link SortRestriction }
     * 
     * 
     */
    public List<Object> getValueRestrictionOrSortRestriction() {
        if (valueRestrictionOrSortRestriction == null) {
            valueRestrictionOrSortRestriction = new ArrayList<Object>();
        }
        return this.valueRestrictionOrSortRestriction;
    }

    /**
     * Gets the value of the causalLink property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the causalLink property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCausalLink().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CausalLink }
     * 
     * 
     */
    public List<CausalLink> getCausalLink() {
        if (causalLink == null) {
            causalLink = new ArrayList<CausalLink>();
        }
        return this.causalLink;
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

    /**
     * Gets the value of the taskSchema property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getTaskSchema() {
        return taskSchema;
    }

    /**
     * Sets the value of the taskSchema property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setTaskSchema(Object value) {
        this.taskSchema = value;
    }

}
