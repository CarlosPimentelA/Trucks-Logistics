package com.trucks_logistics.Trucks.Logistics.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void enviarCodigoVerificacion(String emailDestino, int codigo) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setTo(emailDestino);
            helper.setFrom("trazo@gmail.com");
            helper.setSubject("Verifica tu cuenta - Trucks Logistics");

            // Creamos el cuerpo del correo con HTML
            String htmlContent = """
                    <div style="font-family: Arial; background-color: #f4f4f4; padding: 20px;">
                        <div style="background-color: #ffffff; padding: 40px; border-radius: 10px; text-align: center; max-width: 500px; margin: auto;">
                            <h2 style="color: #333;">Verifica tu cuenta de trazo</h2>
                            <p>Gracias por registrarte. Tu código de verificación es:</p>
                            <div style="font-size: 32px; font-weight: bold; background: #eee; padding: 10px; margin: 20px; border-radius: 5px;">
                                %d
                            </div>
                            <p style="font-size: 13px; color: #666;">Este código expira pronto.</p>
                        </div>
                    </div>
                    """
                    .formatted(codigo);

            helper.setText(htmlContent, true); // El 'true' es vital: indica que es HTML

            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Error al enviar el correo", e);
        }
    }
}
