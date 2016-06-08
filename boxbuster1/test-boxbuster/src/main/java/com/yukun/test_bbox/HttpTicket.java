package com.yukun.test_bbox;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "ticket")
public class HttpTicket {
	@XmlElement
	public long id;

	@XmlElement
	public long movieId;

	@XmlElement
	public long theaterId;

	@XmlElement
	public double price;

	@XmlElement
	public boolean status;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (movieId ^ (movieId >>> 32));
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (status ? 1231 : 1237);
		result = prime * result + (int) (theaterId ^ (theaterId >>> 32));
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
		HttpTicket other = (HttpTicket) obj;
		if (id != other.id)
			return false;
		if (movieId != other.movieId)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (status != other.status)
			return false;
		if (theaterId != other.theaterId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HttpTicket [id=" + id + ", movieId=" + movieId + ", theaterId=" + theaterId + ", price=" + price
				+ ", status=" + status + "]";
	}
	
}