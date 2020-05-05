package Service;

import com.central.erros.model.User;
import com.central.erros.repository.UserRepository;
import com.central.erros.service.EmailNaoEncontradoException;
import com.central.erros.service.Imp.UserServiceImp;
import com.central.erros.service.UserService;
import com.central.erros.service.UnicidadeEmailException;
import com.central.erros.service.unicidadeTokenException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


import static java.util.Optional.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class userServiceTest {
    final String NOME = "Raila";
    final String TOKEN = "adsadasildjalsjdajsdasljdl";
    final String EMAIL = "railaandrade2@gmail.com";

    @MockBean
    private UserRepository userRepository;
    private UserService sut;

    private User user;



    @Before
    public void setUp() throws Exception {
        sut = new UserServiceImp(userRepository);
        user = new User();
        user.setId((long) 1);
        user.setEmail(EMAIL);
        user.setName(NOME);
        user.setPassword("1234");
       // user.setTokenAccess(TOKEN);
       // when(userRepository.findByTokenAccess(TOKEN)).thenReturn(empty());
        //when(userRepository.findByEmail(EMAIL)).thenReturn(empty());
    }

    @Test
    public void deve_salvar_usuario_no_repositorio() throws Exception {
        sut.userSave(user);
        verify(userRepository).save(user);

    }
    @Test(expected = UnicidadeEmailException.class)
    public void nao_deve_salvar_usuario_com_mesmo_email() throws Exception{
        when(userRepository.findByEmail(EMAIL)).thenReturn(user);
        sut.userSave(user);
    }

    @Test(expected = unicidadeTokenException.class)
    public void nao_deve_salvar_usuario_com_mesmo_token() throws Exception {
      //  when(userRepository.findByTokenAccess(TOKEN)).thenReturn(of(user));
        sut.userSave(user);

    }
    @Test(expected = EmailNaoEncontradoException.class)
    public void deve_retornar_excecao_de_nao_encontrado_quando_nao_existir_usuario_com_email () throws Exception{
    //Optional<User> optional= userRepository.findByEmail(EMAIL);
    //return userRepository.findByEmail(EMAIL).get();
        sut.SearchByEmail(EMAIL);
    }
    @Test
    public void deve_buscar_usuario_pelo_email () throws Exception {
        when(userRepository.findByEmail(EMAIL)).thenReturn(user);
        User usuarioTeste = sut.SearchByEmail(EMAIL);
        verify(userRepository).findByEmail(EMAIL);
        assertThat(usuarioTeste).isNotNull();
        assertThat(usuarioTeste.getName()).isEqualTo(NOME);


    }
}
