package com.github.phiz71.vertx.swagger.codegen;

import io.swagger.codegen.SwaggerCodegen;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class SampleVertXGeneratorTest {

	@Before
	public void beforeEach() throws IOException {
		FileUtils.deleteDirectory(new File("temp"));
	}

	@Test
	public void generateSampleServer() {
		String[] args = new String[11];
		args[0] = "generate";
		args[1] = "-l";
		args[2] = "java-vertx";
		args[3] = "-i";
		args[4] = "petStore.json";
		args[5] = "-o";
		args[6] = "../../sample/petstore-vertx-server";
		args[7] = "--group-id";
		args[8] = "io.swagger";
		args[9] = "--artifact-id";
		args[10] = "petstore-vertx-server";
		SwaggerCodegen.main(args);
	}

	@Test
	public void generateSampleServerWithJson() {
		String[] args = new String[12];
		args[0] = "generate";
		args[1] = "-l";
		args[2] = "java-vertx";
		args[3] = "-i";
		args[4] = "petStore.json";
		args[5] = "-o";
		args[6] = "../../sample/petstore-vertx-json-server";
		args[7] = "--group-id";
		args[8] = "io.swagger";
		args[9] = "--artifact-id";
		args[10] = "petstore-vertx-json-server";
		args[11] = "-DjsonObjectModelGeneration=true";
		SwaggerCodegen.main(args);
	}

	@Test
	public void generateSampleServerWithRX() {
		String[] args = new String[12];
		args[0] = "generate";
		args[1] = "-l";
		args[2] = "java-vertx";
		args[3] = "-i";
		args[4] = "petStore.json";
		args[5] = "-o";
		args[6] = "../../sample/petstore-vertx-rx-server";
		args[7] = "--group-id";
		args[8] = "io.swagger";
		args[9] = "--artifact-id";
		args[10] = "petstore-vertx-rx-server";
		args[11] = "-DrxInterface=true";
		SwaggerCodegen.main(args);
	}

	@Test
	public void generateSampleServerWithRXWithJson() {
		String[] args = new String[12];
		args[0] = "generate";
		args[1] = "-l";
		args[2] = "java-vertx";
		args[3] = "-i";
		args[4] = "petStore.json";
		args[5] = "-o";
		args[6] = "../../sample/petstore-vertx-json-rx-server";
		args[7] = "--group-id";
		args[8] = "io.swagger";
		args[9] = "--artifact-id";
		args[10] = "petstore-vertx-json-rx-server";
		args[11] = "-DrxInterface=true,jsonObjectModelGeneration=true";
		SwaggerCodegen.main(args);
	}

	@Test
	public void testOptionalMainApiVerticleTrue() {
		String[] args = new String[8];
		args[0] = "generate";
		args[1] = "-l";
		args[2] = "java-vertx";
		args[3] = "-i";
		args[4] = "testOptionalMainApiVerticle.json";
		args[5] = "-o";
		args[6] = "temp/test-server";
		args[7] = "-DmainVerticleGeneration=true";
		SwaggerCodegen.main(args);

		File mainApiFile = new File(
				"temp/test-server/src/main/java/io/swagger/server/api/MainApiVerticle.java");
		Assert.assertTrue(mainApiFile.exists());
	}

	@Test
	public void testOptionalMainApiVerticleDefaultValue() {
		String[] args = new String[7];
		args[0] = "generate";
		args[1] = "-l";
		args[2] = "java-vertx";
		args[3] = "-i";
		args[4] = "testOptionalMainApiVerticle.json";
		args[5] = "-o";
		args[6] = "temp/test-server";
		SwaggerCodegen.main(args);

		File mainApiFile = new File(
				"temp/test-server/src/main/java/io/swagger/server/api/MainApiVerticle.java");
		Assert.assertTrue(mainApiFile.exists());
	}

	@Test
	public void testOptionalMainApiVerticleFalse() {
		String[] args = new String[8];
		args[0] = "generate";
		args[1] = "-l";
		args[2] = "java-vertx";
		args[3] = "-i";
		args[4] = "testOptionalMainApiVerticle.json";
		args[5] = "-o";
		args[6] = "temp/test-server";
		args[7] = "-DmainVerticleGeneration=false";
		SwaggerCodegen.main(args);

		File mainApiFile = new File(
				"temp/test-server/src/main/java/io/swagger/server/api/MainApiVerticle.java");
		Assert.assertTrue(!mainApiFile.exists());
	}

	@Test
	public void testBodyWithList() throws IOException {
		String[] args = new String[7];
		args[0] = "generate";
		args[1] = "-l";
		args[2] = "java-vertx";
		args[3] = "-i";
		args[4] = "testListInBody.json";
		args[5] = "-o";
		args[6] = "temp/test-server";
		SwaggerCodegen.main(args);

		File testApiVerticleFile = new File(
				"temp/test-server/src/main/java/io/swagger/server/api/verticle/TestApiVerticle.java");

		Assert.assertTrue(FileUtils.readFileToString(testApiVerticleFile)
				.replace("\r\n", "")
				.replace("\n", "")
				.replace("\t", "")
				.replace("  ", "")
				.contains(
						"List<String> updateModel = io.vertx.core.json.Json.mapper.readValue(java.util.Optional.ofNullable(message.body().getJsonArray(\"updateModel\")).map(io.vertx.core.json.JsonArray::encode).orElse(\"null\"),new TypeReference<List<String>>() {});"));
	}

	@Test
	public void testUUID() throws IOException {
		String[] args = new String[7];
		args[0] = "generate";
		args[1] = "-l";
		args[2] = "java-vertx";
		args[3] = "-i";
		args[4] = "testUUID.json";
		args[5] = "-o";
		args[6] = "temp/test-server";
		SwaggerCodegen.main(args);

		File testApiVerticleFile = new File(
				"temp/test-server/src/main/java/io/swagger/server/api/verticle/TestApiVerticle.java");

		Assert.assertTrue(FileUtils.readFileToString(testApiVerticleFile)
				.replace("\r\n", "")
				.replace("\n", "")
				.replace("\t", "")
				.replace("  ", "")
				.contains(
						"UUID uuidParam = io.vertx.core.json.Json.mapper.readValue(" +
								"message.body().getJsonObject(\"uuidParam\").encode(), UUID.class);"));
	}

	@Test
	public void testImplGenWithoutImplDefault() {
		String[] args = new String[7];
		args[0] = "generate";
		args[1] = "-l";
		args[2] = "java-vertx";
		args[3] = "-i";
		args[4] = "testUUID.json";
		args[5] = "-o";
		args[6] = "temp/test-server";
		SwaggerCodegen.main(args);

		File testApiVerticleFile = new File(
				"temp/test-server/src/main/java/io/swagger/server/api/verticle/TestApiImpl.java");

		Assert.assertTrue(!testApiVerticleFile.exists());
	}

	@Test
	public void testImplGenWithoutImplWithOptionFalse() {
		String[] args = new String[8];
		args[0] = "generate";
		args[1] = "-l";
		args[2] = "java-vertx";
		args[3] = "-i";
		args[4] = "testUUID.json";
		args[5] = "-o";
		args[6] = "temp/test-server";
		args[7] = "-DapiImplGeneration=false";
		SwaggerCodegen.main(args);

		File testApiVerticleFile = new File(
				"temp/test-server/src/main/java/io/swagger/server/api/verticle/TestApiImpl.java");

		Assert.assertTrue(!testApiVerticleFile.exists());
	}

	@Test
	public void testImplGenWithoutImplWithOptionTrue() {
		String[] args = new String[8];
		args[0] = "generate";
		args[1] = "-l";
		args[2] = "java-vertx";
		args[3] = "-i";
		args[4] = "testUUID.json";
		args[5] = "-o";
		args[6] = "temp/test-server";
		args[7] = "-DapiImplGeneration=true";
		SwaggerCodegen.main(args);

		File testApiVerticleFile = new File(
				"temp/test-server/src/main/java/io/swagger/server/api/verticle/TestApiImpl.java");

		Assert.assertTrue(testApiVerticleFile.exists());
	}

	@Test
	public void testDefaultValue() throws IOException {
		String[] args = new String[7];
		args[0] = "generate";
		args[1] = "-l";
		args[2] = "java-vertx";
		args[3] = "-i";
		args[4] = "testDefaultValue.json";
		args[5] = "-o";
		args[6] = "temp/test-server";
		SwaggerCodegen.main(args);

		File testApiVerticleFile = new File(
				"temp/test-server/src/main/java/io/swagger/server/api/verticle/TestApiVerticle.java");

		String content = FileUtils.readFileToString(testApiVerticleFile)
				.replace("\r\n", "")
				.replace("\n", "")
				.replace("\t", "")
				.replace("  ", "");
		Assert.assertTrue(content.contains("BigDecimal customValue = null;"));
		Assert.assertTrue(content
				.contains("if (message.body().getString(\"customValue\") != null) {"));
		Assert.assertTrue(content.contains(
				"customValue = io.vertx.core.json.Json.mapper.readValue(message.body().getString(\"customValue\"), BigDecimal.class);"));
	}
}
