//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.17 at 05:46:49 PM CET 
//


package pandadomain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element ref="{}atomic"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "atomic"
})
@XmlRootElement(name = "leftHandSide")
public class LeftHandSide {

    @XmlElement(required = true)
    protected Atomic atomic;

    /**
     * Gets the value of the atomic property.
     * 
     * @return
     *     possible object is
     *     {@link Atomic }
     *     
     */
    public Atomic getAtomic() {
        return atomic;
    }

    /**
     * Sets the value of the atomic property.
     * 
     * @param value
     *     allowed object is
     *     {@link Atomic }
     *     
     */
    public void setAtomic(Atomic value) {
        this.atomic = value;
    }

}