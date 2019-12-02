package cenarios_testes;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import core.ConfigUrl;
import pages.DeleteCustomerPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeleteCustomerTest {
	private static ConfigUrl config=null;
	private static DeleteCustomerPage delCustomer=null;
	
	@BeforeClass
	public static void verificacaoParam() throws Exception {
		config = new ConfigUrl();
		delCustomer = new DeleteCustomerPage(config.getDriver());
	}
	
	public void voltarTelaInicial() {
		delCustomer.backHomepage();
	}
	public void procurarNome() {
		delCustomer.searchName();
	}
	public void acionarBotaoDel() {
		delCustomer.buttonDelete();
	}
	public void visualizarModal() {
		delCustomer.modalAlert();
	}
	
}
