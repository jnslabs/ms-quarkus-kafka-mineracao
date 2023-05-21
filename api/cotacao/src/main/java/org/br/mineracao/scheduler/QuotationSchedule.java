package org.br.mineracao.scheduler;

import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.br.mineracao.service.QuotationService;

/**
 * @Autor Jairo Nascimento
 * @Created 21/05/2023 - 16:35
 */

@ApplicationScoped
public class QuotationSchedule {

    @Inject
    QuotationService quotationService;

    @Transactional
    @Scheduled(every = "35s", identity = "task-job")
    void schedule() {
        quotationService.getCurrencyPrice();
    }
}
