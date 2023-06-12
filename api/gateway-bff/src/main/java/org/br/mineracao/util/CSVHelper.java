package org.br.mineracao.util;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.br.mineracao.dto.OpportunityDTO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

/**
 * @Autor Jairo Nascimento
 * @Created 23/05/2023 - 17:24
 */
public class CSVHelper {

    public static ByteArrayInputStream OpportunitiesToCSV(List<OpportunityDTO> opportunities) {
        final CSVFormat format = CSVFormat.DEFAULT.withHeader("ID Proposta", "Cliente", "Preço por tonelada", "Melhor cotação de Moeda");

        try (
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                CSVPrinter csvPrinter = new CSVPrinter(new PrintStream(out), format);
                ) {
            for (OpportunityDTO opps : opportunities) {
                List<String> data = Arrays.asList(String.valueOf(opps.getProposalId()),
                        opps.getCustomer(), String.valueOf(opps.getPriceTonne()), String.valueOf(opps.getLastDollarQuotation()));
                csvPrinter.printRecord(data);
            }
            csvPrinter.flush();

            return new ByteArrayInputStream(out.toByteArray());

        } catch (IOException e) {
            throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
        }
    }
}
