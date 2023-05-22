package org.br.mineracao.scheduler;

import io.quarkus.scheduler.Scheduled;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.br.mineracao.service.QuotationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Autor Jairo Nascimento
 * @Created 21/05/2023 - 16:35
 */

@ApplicationScoped
public class QuotationSchedule {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Inject
    QuotationService quotationService;

    @Transactional
    @Scheduled(every = "35s", identity = "task-job")
    void schedule() {
        LOG.info("--- Executando scheduler --");
        quotationService.getCurrencyPrice();
    }
}
