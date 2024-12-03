package sample.cafekiosk.spring.api.service.mail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import sample.cafekiosk.spring.client.mail.MailSendClient;
import sample.cafekiosk.spring.domain.history.mail.MailSendHistory;
import sample.cafekiosk.spring.domain.history.mail.MailSendHistoryRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class MailServiceTest {

    @DisplayName("메일 전송 테스트")
    @Test
    void sendMail() {
        // given
        MailSendClient mailSendClient = Mockito.mock(MailSendClient.class);
        MailSendHistoryRepository mailSendHistoryRepository = Mockito.mock(MailSendHistoryRepository.class);

        MailService mailService = new MailService(mailSendClient, mailSendHistoryRepository);

        when(mailSendClient.sendEmail(anyString(), anyString(), anyString(), anyString()))
                .thenReturn(true);
//        when(mailSendHistoryRepository.save(any(MailSendHistory.class)))
//                .thenReturn();

        // when
        boolean result = mailService.sendMail("", "", "", "");

        // then
        assertThat(result).isTrue();
    }

}