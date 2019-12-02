package cenarios_testes;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import core.ConfigUrl;
import pages.AddCustomerPage;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AddCustomerTest {
	private static ConfigUrl config=null;
	private static AddCustomerPage addCustomer=null;
	
	
@BeforeClass
public static void verificacaoParam() throws Exception {
	config = new ConfigUrl();
    addCustomer = new AddCustomerPage(config.getDriver());
}
	
@Test
public void a_alterarVersaoBootstrap() {
	addCustomer.alterVersion();
}

@Test
public void b_acessarFormulario() {
	addCustomer.customerButton();
}

@Test
public void c_preencherFormulario() {
	addCustomer.includeCustomer();
}

@Test
public void d_validarMensagemSucesso(){
	addCustomer.valSucess();
}

@AfterClass
public static void sairNavegador() {
	addCustomer.exitBrowser();
}
}
