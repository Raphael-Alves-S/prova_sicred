package cenarios_testes;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import core.ConfigUrl;
import pages.AddCustormerPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AddCustomerTest {
	private static ConfigUrl config=null;
	private static AddCustormerPage addCustomer=null;
	
	
@BeforeClass
public static void verificacaoParam() throws Exception {
	config = new ConfigUrl();
    addCustomer = new AddCustormerPage(config.getDriver());
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
}
