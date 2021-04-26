package ar.com.bna.ws.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ar.com.bna.ws.dto.Cheque;
import ar.gov.bna.ws.exception.CustomFault;

public class ServicioCheques {

	private static List<Cheque> cheques = new ArrayList<Cheque>();

	public void generarCheques() {
		ServicioCheques.cheques = new ArrayList<Cheque>();
		Cheque uno = new Cheque(1L, "010", new BigDecimal("1000.00"), "24598754", "AABBCCC123", new Date());
		Cheque dos = new Cheque(2L, "013", new BigDecimal("575.30"), "21234778", "KKSKFK&W", new Date());
		Cheque tres = new Cheque(3L, "027", new BigDecimal("2534.88"), "12247887", "KDFSKDGKSFKYYK777", new Date());
		cheques.add(uno);
		cheques.add(dos);
		cheques.add(tres);

	}

	public void agregarCheque(Cheque cheque) {
		if (cheques.isEmpty())
			generarCheques();
		else {
			cheque.setId(new Long(cheques.size() + 1));
			cheques.add(cheque);
		}
	}

	public Cheque buscarCheque(Long id) throws CustomFault {
		for (Cheque cheque : cheques) {
			if (cheque.getId().equals(id))
				return cheque;
		}

		throw new CustomFault("No se encontro el Cheque con id: " + id);
	}

	public List<Cheque> listarCheques() {
		if(cheques.isEmpty())
    		generarCheques();
		return cheques;
	}
	
	public Cheque ultimo() {
		return cheques.get(cheques.size() - 1);
	}

	public static List<Cheque> getCheques() {
		return cheques;
	}

	public static void setCheques(List<Cheque> cheques) {
		ServicioCheques.cheques = cheques;
	}

}
