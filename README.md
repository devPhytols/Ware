# 🤖 Ware - Bot Discord Básico em Java

Um bot **simples, moderno e funcional**, construído com [JDA][jda] e Gradle.  
Ideal para quem quer aprender a criar bots no Discord com Java. 🚀

---

## 📁 Estrutura do Projeto

Todo o código-fonte está localizado em:  
[`src/main/java/org/ware`](https://github.com/devPhytols/Ware/tree/main/src/main/java/org/ware)

---

## 🔑 Pré-requisitos

Você só precisa de uma coisa:  
✅ **Token do seu bot do Discord**

> Caso não saiba como gerar um token, consulte a [documentação oficial do Discord](https://discord.com/developers/docs/intro).

---

## 🛠️ Como Rodar Localmente

Siga os passos abaixo para clonar, compilar e executar o Ware no seu ambiente local:

```bash
# 1. Clone o repositório
git clone https://github.com/devPhytols/Ware.git

# 2. Acesse o diretório do projeto
cd Ware/

# 3. Compile o projeto com o Gradle
./gradlew clean build

# 4. Execute o bot, substituindo pelo seu token
./gradlew run --args "SEU_TOKEN_DO_DISCORD"
