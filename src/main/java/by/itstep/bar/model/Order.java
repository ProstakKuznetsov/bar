package by.itstep.bar.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ElementCollection
	private Map<Drink, Integer> drinks;

	private BigDecimal totalCost;

	private Boolean isClosed;

	private Boolean isPaid;

	public BigDecimal getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getIsClosed() {
		return isClosed;
	}

	public void setIsClosed(Boolean isClosed) {
		this.isClosed = isClosed;
	}

	public Boolean getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(Boolean isPaid) {
		this.isPaid = isPaid;
	}

	public Map<Drink, Integer> getDrinks() {
		return drinks;
	}

	public void setDrinks(Map<Drink, Integer> drinks) {
		this.drinks = drinks;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((drinks == null) ? 0 : drinks.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isClosed == null) ? 0 : isClosed.hashCode());
		result = prime * result + ((isPaid == null) ? 0 : isPaid.hashCode());
		result = prime * result + ((totalCost == null) ? 0 : totalCost.hashCode());
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
		Order other = (Order) obj;
		if (drinks == null) {
			if (other.drinks != null)
				return false;
		} else if (!drinks.equals(other.drinks))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isClosed == null) {
			if (other.isClosed != null)
				return false;
		} else if (!isClosed.equals(other.isClosed))
			return false;
		if (isPaid == null) {
			if (other.isPaid != null)
				return false;
		} else if (!isPaid.equals(other.isPaid))
			return false;
		if (totalCost == null) {
			if (other.totalCost != null)
				return false;
		} else if (!totalCost.equals(other.totalCost))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", drinks=" + drinks + ", totalCost=" + totalCost + ", isClosed=" + isClosed
				+ ", isPaid=" + isPaid + "]";
	}

}
