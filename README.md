# 🧛 Matador_de_Processos
Algoritmo responsável pela finalização de processos. Execução independente do SO.

## 🤔 O que faz?
Manda um sinal para *matar* um processo através do PID (identificação única do processo), ou através de seu nome.

### Como usar:
1. Clone localmente esse repositório:
```bash
git clone https://github.com/GabrielGit10110/Matador_de_Processos.git
```

*(2a: terminal, 2b: IDE)*
2.a Entre no diretório clonado:
```bash
cd Matador_de_Processos
```

2.a2 Compile os arquivos para arquivos.class:
```bash
javac -s src -d bin /src/controller/KillController.java /src/view/Main.java
```

2.a3 Execute:
```bash
java -cp dist view.Main
```

---

2.b Importe a pasta com o projeto em sua IDE (Eclipse, Intellij, etc).

2.b2 Execute ou compile para um jar executável.
