package fuhrpark;

import auto.*;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import com.sun.xml.txw2.annotation.XmlNamespace;

import start.AutoDTO;
import start.KleinwagenDTO;
import auto.Auto;

@XmlRootElement(name = "Fuhrpark")
@XmlSeeAlso({Kleinwagen.class })
public class Fuhrpark {
	private Map<Integer, Auto> autos;
	private AutoManager manager;

	public Fuhrpark() {

		manager = new AutoManager();
		this.autos = manager.getAutos();
	}

	@XmlElementWrapper(name = "Autos")
	@XmlElement(name = "Auto")
	public Collection<Auto> getAutos() {
		return autos.values();
	}

	public void setAutos(Map<Integer, Auto> autos) {
		this.autos = autos;
	}

	public void addAuto(AutoDTO auto) {
		manager.addAuto(auto);
	}
	
	public void addAuto(KleinwagenDTO wagen){
		manager.addAuto(wagen);
	}

	public Auto getAuto(Auto auto) {
		for (Auto a : autos.values()) {
			if (a.getMarke() == auto.getMarke()) {
				return a;
			}
		}
		return null;
	}
}
