package org.anveshgadde.decryptionfunction;

import org.apache.commons.lang3.builder.EqualsBuilder;

public class EncryptionParameters {

	private final String token, algorithm;

	public EncryptionParameters(String token, String algorithm) {
		this.token = token;
		this.algorithm = algorithm;
	}

	public String getToken() {
		return token;
	}

	public String getAlgorithm() {
		return algorithm;
	}

	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = prime * result + ((algorithm == null) ? 0 : algorithm.hashCode());
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (obj instanceof EncryptionParameters) {
			EncryptionParameters other = (EncryptionParameters) obj;
			return new EqualsBuilder().append(algorithm, other.algorithm).append(token, other.token).isEquals();
		}
		return false;

	}

}
