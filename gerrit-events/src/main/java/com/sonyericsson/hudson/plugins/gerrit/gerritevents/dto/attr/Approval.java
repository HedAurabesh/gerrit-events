/*
 *  The MIT License
 *
 *  Copyright 2012 Copyright 2012 Hewlett-Packard Development Company, L.P.
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 */
package com.sonyericsson.hudson.plugins.gerrit.gerritevents.dto.attr;

import static com.sonyericsson.hudson.plugins.gerrit.gerritevents.GerritJsonEventFactory.getString;
import com.sonyericsson.hudson.plugins.gerrit.gerritevents.dto.GerritJsonDTO;
import net.sf.json.JSONObject;

import static com.sonyericsson.hudson.plugins.gerrit.gerritevents.dto.GerritEventKeys.TYPE;
import static com.sonyericsson.hudson.plugins.gerrit.gerritevents.dto.GerritEventKeys.VALUE;

/**
 * Represents a Gerrit JSON Approval DTO.
 * @author James E. Blair &lt;jeblair@hp.com&gt;
 */
public class Approval implements GerritJsonDTO {

    /**
     * The approval category.
     */
    private String type;
    /**
     * The approval value
     */
    private String value;

    /**
     * Default constructor.
     */
    public Approval() {
    }

    /**
     * Constructor that fills with data directly.
     * @param json the JSON object with corresponding data.
     */
    public Approval(JSONObject json) {
        this.fromJson(json);
    }

    @Override
    public void fromJson(JSONObject json) {
    	if (json.containsKey(TYPE) && json.containsKey(VALUE)) {
    		type = getString(json, TYPE);
    		value = getString(json, VALUE);
        }
    }

    /**
     * The approval category.
     * @return the type.
     */
    public String getType() {
        return type;
    }

    /**
     * The approval category
     * @param type the type.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * The approval value
     * @return the approval value.
     */
    public String getValue() {
        return value;
    }

    /**
     * Set the approval value
     * @param value the approval value.
     */
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Approval: " + getType() + " " + getValue();
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		Approval other = (Approval) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
}
