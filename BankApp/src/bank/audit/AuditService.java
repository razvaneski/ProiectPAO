package bank.audit;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class AuditService {
    FileWriter writer;
    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    public void logAction(String action) throws IOException {
        writer.append(action);
        writer.append(",");
        writer.append(formatter.format(LocalDateTime.now()));
        writer.append("\n");
        writer.flush();
    }
    public AuditService() {
        try {
            this.writer = new FileWriter("data/audit.csv");
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}