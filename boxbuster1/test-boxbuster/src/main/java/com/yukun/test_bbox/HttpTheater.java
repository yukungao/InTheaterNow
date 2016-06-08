package com.yukun.test_bbox;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "theater")
public class HttpTheater {
	
	@XmlElement
	public long id;
	@XmlElement
	public String name;
	
	// Can't handle interface, how to solve it?
	//@XmlElement
	//public Address address;
	
	@XmlElement
	public int seats;

	@Override
	public String toString() {
		return "HttpTheater [id=" + id + ", name=" + name + ", seats=" + seats + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + seats;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HttpTheater other = (HttpTheater) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (seats != other.seats)
			return false;
		return true;
	}
	
	

}
