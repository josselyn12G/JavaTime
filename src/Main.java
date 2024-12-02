//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.swing.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        // 1. Fecha y hora actual
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Fecha actual: " + today);
        System.out.println("Hora actual: " + now);
        System.out.println("Fecha y hora actual: " + currentDateTime);

        // 2. Formatear fecha y hora
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        System.out.println("Fecha y hora formateada: " + formattedDateTime);

        // 3. Sumar y restar días/meses/años
        LocalDate nextWeek = today.plusDays(7);
        LocalDate lastMonth = today.minusMonths(1);
        System.out.println("Dentro de 7 días: " + nextWeek);
        System.out.println("Hace un mes: " + lastMonth);

        // 4. Calcular diferencias entre fechas
        LocalDate birthday = LocalDate.of(1995, 5, 23);
        Period period = Period.between(birthday, today);
        System.out.println("Edad: " + period.getYears() + " años, "
                + period.getMonths() + " meses, "
                + period.getDays() + " días");

        // 5. Trabajar con zonas horarias
        ZonedDateTime utcTime = ZonedDateTime.now(ZoneId.of("UTC"));
        ZonedDateTime nyTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println("Hora actual en UTC: " + utcTime);
        System.out.println("Hora actual en Nueva York: " + nyTime);

        // 6. Comparar fechas
        LocalDate deadline = LocalDate.of(2024, 12, 31);
        if (today.isBefore(deadline)) {
            System.out.println("Todavía tienes tiempo para la fecha límite.");
        } else {
            System.out.println("La fecha límite ha pasado.");
        }

        // 7. Convertir cadenas a fechas
        String dateText = "01/12/2024";
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate parsedDate = LocalDate.parse(dateText, dateFormatter);
        System.out.println("Fecha convertida desde texto: " + parsedDate);

        // 8. Calcular diferencias en unidades específicas (opcional)
        long daysUntilDeadline = ChronoUnit.DAYS.between(today, deadline);
        System.out.println("Días hasta la fecha límite: " + daysUntilDeadline);

        // Formateador para la fecha
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Solicitar la fecha al usuario con JOptionPane
        String inputDate = JOptionPane.showInputDialog("Por favor, ingresa una fecha en el formato dd/MM/yyyy:");

        // Convertir la entrada en un objeto LocalDate
        LocalDate enteredDate = LocalDate.parse(inputDate, formatter);
        LocalDate today = LocalDate.now();

        // Comparar las fechas y preparar el mensaje
        String message;
        if (enteredDate.isBefore(today)) {
            message = "La fecha ingresada (" + enteredDate + ") está en el pasado.";
        } else if (enteredDate.isAfter(today)) {
            message = "La fecha ingresada (" + enteredDate + ") está en el futuro.";
        } else {
            message = "¡La fecha ingresada (" + enteredDate + ") es hoy!";
        }

        // Mostrar el resultado en un cuadro de diálogo
        JOptionPane.showMessageDialog(null, message);

    }
}
