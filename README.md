# Carteirinha Digital

Aplicativo Android em Jetpack Compose. A interface mantém o tema escuro e os componentes visuais do projeto.

## Fluxo do aluno

1. Informe as credenciais cadastradas no backend. O aplicativo envia `POST /auth/login` com `login` e `senha`.
2. A página inicial e a carteirinha exibem nome, curso, turma e ID devolvidos pela API; o QR Code codifica o ID do aluno.
3. A tela de unidades curriculares consulta `GET /unidades-curriculares` com o token recebido no login. Ela mostra nome, professor, N1, N2, média e faltas, além de estados de carregamento, erro e lista vazia.
4. Ao sair, a sessão e o token em memória são apagados.

O atalho **Entrar como professor** abre as telas visuais de professor sem login, conforme o requisito da atividade. As telas de turmas e de unidades do professor ainda contêm dados de apresentação: o repositório de referência não define endpoints de professor ou de turmas. Elas não enviam notas ou presença ao servidor.

## Configuração da API

Por padrão, o app aponta para `http://10.0.2.2:8080/`, que alcança uma API em execução na máquina hospedeira a partir do **emulador Android**. O backend precisa oferecer os dois endpoints e os campos JSON usados nos DTOs do projeto. Em aparelho físico, substitua o endereço por um IP alcançável na mesma rede, terminando com `/`:

```bash
./gradlew :app:assembleDebug -PapiBaseUrl=http://192.168.1.10:8080/
```

O endereço deve apontar para o backend que está rodando; `10.0.2.2` não serve para um celular físico. Recompile o app após mudar o endereço. A permissão de Internet e o tráfego HTTP estão habilitados para a API local de desenvolvimento.
