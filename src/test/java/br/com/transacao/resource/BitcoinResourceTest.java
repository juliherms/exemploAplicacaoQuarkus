package br.com.transacao.resource;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;

/**
 * Classe responsável por testar o resource de Bitcoint
 * 
 * @author jlv
 *
 */
@QuarkusTest
public class BitcoinResourceTest {

	/**
	 * Testa se a listagem de bitcoins esta retornando sucesso.
	 */
	@Test
	public void testarListarBitcoins() {

		RestAssured.given().get("bitcoins").then().statusCode(200);
	}

}
