package br.com.vrsoftware.vrcustomerx.service;

import br.com.vrsoftware.vrcustomerx.dto.FinancialsCustomerxDTO;
import br.com.vrsoftware.vrcustomerx.entities.ReceiveCustomer;
import br.com.vrsoftware.vrcustomerx.entities.ReceiveCustomerItem;
import br.com.vrsoftware.vrcustomerx.enums.SituacaoReceberCliente;
import br.com.vrsoftware.vrcustomerx.repository.IReceiveCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExportFinancialsService {

    @Autowired
    IReceiveCustomerRepository customerContactRepository;

    public FinancialsCustomerxDTO execute(Long financialId) throws Exception{
        Optional<ReceiveCustomer> optinal = customerContactRepository.findById(financialId);

        if(!optinal.isPresent()){
            throw new Exception("Receive " + financialId + " not found.")
        }

        ReceiveCustomer receive = optinal.get();

        FinancialsCustomerxDTO financials = new FinancialsCustomerxDTO();
        financials.setDate_due(receive.getDataVencimento());
        financials.setDate_issue(receive.getDataProcessamento());
        financials.setDate_payment(receive.getDataPagamento());
        financials.setExternal_id_financial(String.valueOf(receive.getId()));
        financials.setExternal_id_client(String.valueOf(receive.getIdCliente()));
        financials.setStatus(getStatus(receive.getIdSituacaoReceberCliente()));
        financials.setIdentifier(String.valueOf(receive.getId()));
        financials.setAmount_paid(getAmountPaid(receive.getIdSituacaoReceberCliente(), receive.getItems()));
        financials.setDiscount_value(0.00);


    }

    private Double getAmountPaid(Integer idSituacaoReceberCliente, List<ReceiveCustomerItem> items){

        if(idSituacaoReceberCliente != SituacaoReceberCliente.PAGO.getId()){
            return 0.00;
        }

        Double amount = 0.00;

        for(ReceiveCustomerItem receiveItem : items){
            amount +=  receiveItem.getValorVR() + receiveItem.getValorUnidade();
        }

        return amount
    }

    private String getStatus(Integer idSituacaoReceberCliente) throws Exception{
        if(idSituacaoReceberCliente == SituacaoReceberCliente.ABERTO.getId()){
            return "pending";
        }

        if(idSituacaoReceberCliente == SituacaoReceberCliente.PAGO.getId()){
            return "received";
        }

        if(idSituacaoReceberCliente == SituacaoReceberCliente.CANCELADO.getId()){
            return "canceled";
        }

        throw new Exception("Status of receive not found.");
    }
}
