package by.itstep.bar.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "drinks")
public class Drink {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	private BigDecimal bottleVolume;

	private BigDecimal priceForBottle;

	private BigDecimal pricePerServing;

	private Long quantityInWarehouse;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getBottleVolume() {
		return bottleVolume;
	}

	public void setBottleVolume(BigDecimal bottleVolume) {
		this.bottleVolume = bottleVolume;
	}

	public BigDecimal getPriceForBottle() {
		return priceForBottle;
	}

	public void setPriceForBottle(BigDecimal priceForBottle) {
		this.priceForBottle = priceForBottle;
	}

	public BigDecimal getPricePerServing() {
		return pricePerServing;
	}

	public void setPricePerServing(BigDecimal pricePerServing) {
		this.pricePerServing = pricePerServing;
	}

	public Long getQuantityInWarehouse() {
		return quantityInWarehouse;
	}

	public void setQuantityInWarehouse(Long quantityInWarehouse) {
		this.quantityInWarehouse = quantityInWarehouse;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bottleVolume == null) ? 0 : bottleVolume.hashCode());
		result = prime * result + ((quantityInWarehouse == null) ? 0 : quantityInWarehouse.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((priceForBottle == null) ? 0 : priceForBottle.hashCode());
		result = prime * result + ((pricePerServing == null) ? 0 : pricePerServing.hashCode());
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
		Drink other = (Drink) obj;
		if (bottleVolume == null) {
			if (other.bottleVolume != null)
				return false;
		} else if (!bottleVolume.equals(other.bottleVolume))
			return false;
		if (quantityInWarehouse == null) {
			if (other.quantityInWarehouse != null)
				return false;
		} else if (!quantityInWarehouse.equals(other.quantityInWarehouse))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (priceForBottle == null) {
			if (other.priceForBottle != null)
				return false;
		} else if (!priceForBottle.equals(other.priceForBottle))
			return false;
		if (pricePerServing == null) {
			if (other.pricePerServing != null)
				return false;
		} else if (!pricePerServing.equals(other.pricePerServing))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Drink [id=" + id + ", name=" + name + ", bottleVolume=" + bottleVolume + ", priceForBottle="
				+ priceForBottle + ", pricePerServing=" + pricePerServing + ", countByWarehouse=" + quantityInWarehouse
				+ "]";
	}
}