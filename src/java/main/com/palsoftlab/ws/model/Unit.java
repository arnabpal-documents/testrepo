package com.palsoftlab.ws.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Unit {

	@XmlElement(name="unitid")
	private String unitId;
	@XmlElement(name = "unitname")
	private String unitName;
	@XmlElement(name = "parentunitid")
	private String parentUnitId = null;
	@XmlElement(name = "childunits")
	private List<Unit> childUnits = null;
	@XmlElement(name = "unitusers")
	private List<User> unitUsers = new ArrayList<User>();

	public Unit() {
	}

	public Unit(String unitId, String unitName, String parentId) {
		this.unitId = unitId;
		this.unitName = unitName;
		this.parentUnitId = parentId;
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public List<Unit> getChildUnits() {
		if (childUnits == null) {
			childUnits = new ArrayList<Unit>();
		}
		return childUnits;
	}

	public void setChildUnits(List<Unit> childUnits) {
		this.childUnits = childUnits;
	}

	@XmlTransient
	public Unit addChildUnit(Unit child) {
		Unit addedUnit = null;
		if (child != null) {
			getChildUnits().add(child);
			addedUnit = child;
		}
		return addedUnit;

	}

	@XmlTransient
	public Unit removeChild(Unit child) {
		Unit removedUnit = null;
		List<Unit> children = getChildUnits();
		for (Unit unit : children) {
			if (child.equals(unit) && children.remove(child)) {
				removedUnit = child;
				break;
			}
		}

		return removedUnit;
	}

	public List<User> getUnitUsers() {
		return unitUsers;
	}

	public void setUnitUsers(List<User> unitUsers) {
		this.unitUsers = unitUsers;
	}

	public String getParentUnitId() {
		return parentUnitId;
	}

	public void setParentUnitId(String parentUnitId) {
		this.parentUnitId = parentUnitId;
	}

	@XmlTransient
	public boolean hasChildren() {
		return getChildUnits().size() > 0;
	}

	@XmlTransient
	public boolean hasParent() {
		return getParentUnitId() != null;
	}
	
	@XmlTransient
	public String getDescription()
	{
		return getUnitName()+"(ID : "+getUnitId()+")";
	}

	@Override
	@XmlTransient
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((childUnits == null) ? 0 : childUnits.hashCode());
		result = prime * result
				+ ((parentUnitId == null) ? 0 : parentUnitId.hashCode());
		result = prime * result + ((unitId == null) ? 0 : unitId.hashCode());
		result = prime * result
				+ ((unitName == null) ? 0 : unitName.hashCode());
		result = prime * result
				+ ((unitUsers == null) ? 0 : unitUsers.hashCode());
		return result;
	}

	@Override
	@XmlTransient
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Unit other = (Unit) obj;
		if (childUnits == null) {
			if (other.childUnits != null) {
				return false;
			}
		} else if (!childUnits.equals(other.childUnits)) {
			return false;
		}
		if (parentUnitId == null) {
			if (other.parentUnitId != null) {
				return false;
			}
		} else if (!parentUnitId.equals(other.parentUnitId)) {
			return false;
		}
		if (unitId == null) {
			if (other.unitId != null) {
				return false;
			}
		} else if (!unitId.equals(other.unitId)) {
			return false;
		}
		if (unitName == null) {
			if (other.unitName != null) {
				return false;
			}
		} else if (!unitName.equals(other.unitName)) {
			return false;
		}
		if (unitUsers == null) {
			if (other.unitUsers != null) {
				return false;
			}
		} else if (!unitUsers.equals(other.unitUsers)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Unit [unitId=");
		builder.append(unitId);
		builder.append(", unitName=");
		builder.append(unitName);
		builder.append(", parentUnitId=");
		builder.append(parentUnitId);
		builder.append(", childUnits=");
		builder.append(childUnits);
		builder.append(", unitUsers=");
		builder.append(unitUsers);
		builder.append("]");
		return builder.toString();
	}
	

}
