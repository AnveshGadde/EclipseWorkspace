package org.anveshgadde.jsonevents;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JsonEventProcessing {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		String jsonEvent = "{\"eventServerLocalDate\":\"2016-08-03 05:54:59.468\",\"eventLocalDate\":\"2016-08-03 15:23:29.014\",\"deviceSegment\":{\"manufacturer\":\"LGE\",\"osVersion\":\"5.0\",\"deviceName\":\"LG-D855\",\"uniqueDeviceID\":\"zDWQvvlSW8S1Utvyay87eP4xzUOU/ZBzCLiZllOu+/Q=\",\"deviceType\":\"smartPhone\",\"screenResolution\":\"1440x2560\",\"osPlatform\":\"android\"},\"encryptionToken\":\"1000000000003692\",\"schemaVersion\":5,\"installationID\":\"c0404829-bb63-4d7f-b5a7-670a78d00e4c\",\"appID\":5012,\"applicationSessionID\":\"10628039-7746-4c15-9a66-9bb2c23bb781\",\"eventTimezone\":\"Asia/Calcutta\",\"testMode\":false,\"deviceState\":{\"batteryState\":6,\"locale\":\"en_US\",\"deliveryNetwork\":\"wifi\",\"simcardState\":\"unavailable\"},\"sequenceNumber\":364,\"eventUTCDate\":\"2016-08-03 09:53:29.014\",\"eventName\":\"VSTB_LIB_START\",\"applicationVersion\":\"1.0\",\"location\":{\"source\":\"none\"},\"routing\":\"ASYNC\",\"vstb\":{\"vstbLibraryVersion\":\"6.1.0.86\",\"vstbApiVersion\":\"6\",\"qpID\":\"56b419e30794e85d\",\"vstbApiRevision\":\"1\"},\"eventServerUTCDate\":\"2016-08-03 09:54:59.468\",\"encryptionAlgorithm\":\"AES\",\"eventID\":25,\"eventUID\":\"b48bae08-d3cc-4073-8476-240a3817dac5\"}";

		String accountID = "decryptedAccID";
		String qpID = "decryptedQpID";
		String country = "decryptedCountry";
		String city = "decryptedCity";
		String latitude = "decryptedLatitude";
		String longitude = "decryptedLongitude";
		String territory = "decryptedTerritory";
		String subAccountID = "decryptedsubAccID";
		String uniqueDeviceID = "decrypteduniDevID";
		String localUrl = "decryptedLocalUrl";

		ObjectMapper mapper = new ObjectMapper();

		JsonNode jsonTree;

		try {
			jsonTree = mapper.readTree(jsonEvent);
			

			//Removal of encryptionToken & Algorithm
			
			((ObjectNode) jsonTree).remove("encryptionToken");
			((ObjectNode) jsonTree).remove("encryptionAlgorithm");


			
			//Replacing decrypted value, iff decryptedValue is not null

			if (!jsonTree.path("user").isMissingNode()) {

				ObjectNode userNode = ((ObjectNode) jsonTree.path("user"));

				if (!userNode.path("accountID").isMissingNode() && userNode.get("accountID").textValue() != null) {

					if (accountID != null) userNode.put("accountID", accountID);
					else throw new RuntimeException("PII decrypt function failed to decrypt accountID");

				}

				if (!userNode.path("subAccountID").isMissingNode() && userNode.get("subAccountID").textValue() != null) {

					if (subAccountID != null)
						userNode.put("subAccountID", subAccountID);
					else
						throw new RuntimeException("PII decrypt function failed to decrypt subAccountID");
				}

			}

			if (!jsonTree.path("location").isMissingNode()) {

				ObjectNode locationNode = ((ObjectNode) jsonTree.path("location"));

				if (!locationNode.path("country").isMissingNode() && locationNode.get("country").textValue() != null) {
					if (country != null)
						locationNode.put("country", country);
					else
						throw new RuntimeException("PII decrypt function failed to decrypt country");
				}

				if (!locationNode.path("city").isMissingNode() && locationNode.get("city").textValue() != null) {
					if (city != null)
						locationNode.put("city", city);
					else
						throw new RuntimeException("PII decrypt function failed to decrypt city");
				}

				if (!locationNode.path("latitude").isMissingNode() && locationNode.get("latitude").textValue() != null) {
					if (latitude.toString() != null)
						locationNode.put("latitude", Double.parseDouble(latitude));
					else
						throw new RuntimeException("PII decrypt function failed to decrypt latitude");
				}

				if (!locationNode.path("longitude").isMissingNode()	&& locationNode.get("longitude").textValue() != null) {
					if (longitude.toString() != null)
						locationNode.put("longitude", Double.parseDouble(longitude));
					else
						throw new RuntimeException("PII decrypt function failed to decrypt longitude");
				}

				if (!locationNode.path("territory").isMissingNode()	&& locationNode.get("territory").textValue() != null) {
					if (territory != null)
						locationNode.put("territory", territory);
					else
						throw new RuntimeException("PII decrypt function failed to decrypt territory");
				}

			}

			if (!jsonTree.path("deviceSegment").path("uniqueDeviceID").isMissingNode() && jsonTree.path("deviceSegment").get("uniqueDeviceID").textValue() != null) {

				if (uniqueDeviceID != null){
					((ObjectNode) jsonTree.path("deviceSegment")).put("uniqueDeviceID", uniqueDeviceID);
					System.out.println("Null value boolean: " +Boolean.valueOf(jsonTree.path("deviceSegment").get("uniqueDeviceID").textValue() != null));
					System.out.println("Empyt value boolean: " +Boolean.valueOf(jsonTree.path("deviceSegment").get("uniqueDeviceID").textValue().isEmpty()));
				}
				else
					throw new RuntimeException("PII decrypt function failed to decrypt uniqueDeviceID");
			}

			if (!jsonTree.path("vstb").path("qpID").isMissingNode() && jsonTree.path("vstb").get("qpID").textValue() != null) {

				if (qpID != null){
					((ObjectNode) jsonTree.path("vstb")).put("qpID", qpID);}
				else throw new RuntimeException("PII decrypt function failed to decrypt qpID");
			}

			if (!jsonTree.path("downloadContent").path("localUrl").isMissingNode() && jsonTree.path("downloadContent").get("localUrl").textValue() != null) {

				if (localUrl != null)
					((ObjectNode) jsonTree.path("downloadContent")).put("localUrl", localUrl);
				else
					throw new RuntimeException("PII decrypt function failed to decrypt localUrl");
			}

			String value = mapper.writeValueAsString(jsonTree);

			System.out.println("Value: " + value.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
