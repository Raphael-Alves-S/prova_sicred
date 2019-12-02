package cenarios_testes;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import core.ConfigUrl;
import pages.DeleteCustomerPage;
import pages.AddCustomerPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeleteCustomerTest {
	private static ConfigUrl config=null;
	private static DeleteCustomerPage delCustomer=null;
	private static AddCustomerPage precondicao = null;
	
	@BeforeClass
	public static void verificacaoParam() throws Exception {
		config = new ConfigUrl();
		delCustomer = new DeleteCustomerPage(config.getDriver());
		precondicao = new AddCustomerPage(config.getDriver());
		
	}
	
	@Test
	public void a_ExecutarDesafio1() {
		precondicao.alterVersion();
		precondicao.customerButton();
		precondicao.includeCustomer();
		precondicao.valSucess();
	}	
	
	@Test
	public void a_voltarTelaInicial() {
		delCustomer.backHomepage();
	}
	
	@Test
	public void b_procurarNome() throws InterruptedException {
		delCustomer.searchName();
	}
	
	@Test
	public void c_acionarBotaoDel() {
		delCustomer.buttonDelete();
	}
	@Test
	public void d_visualizarModal() {
		delCustomer.modalAlert();
	}
	
	@Test
	public void e_deletarUsuario() {
		delCustomer.deleteCustomer();
	}
	
@AfterClass
public static void pararDriver() {
	delCustomer.quitDriver();
}
}
