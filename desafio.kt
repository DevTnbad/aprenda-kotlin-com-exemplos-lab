enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Aluno(val aluno: String) {
    override fun toString(): String {
        return aluno
    }
}

data class ConteudoEducacional(val nome: String, val duracaoDias: Int = 60, val nivel: Nivel)


data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    //######################################################################
    //
    //Testes
    //
    //######################################################################

    val inscritos = mutableSetOf<Aluno>()

    fun matricular(vararg alunos: Aluno) {
    	for (elemento in alunos) {
        	inscritos.add(elemento)
    	}
	}

    fun desmatricular(vararg alunos: Aluno) {
        for (elemento in alunos) {
            if (inscritos.remove(elemento)) {
                println("Usuário ${elemento} foi desmatriculado.")
            } else {
                println("Usuário ${elemento} não está matriculado nesta formação.")
            }
        }
    }
    
    fun getNivel(): Map<Nivel, Int> {
        val nivelContagem = mutableMapOf<Nivel, Int>()
        conteudos.forEach { conteudo ->
            nivelContagem[conteudo.nivel] = (nivelContagem[conteudo.nivel] ?: 0) + 1
        }
        return nivelContagem
    }
 
}

fun main() {
    val aluno1 = Aluno("Toddy")
    val aluno2 = Aluno("Kiara")
    val aluno3 = Aluno("Fiu-fiu")
    val aluno4 = Aluno("Sansao")
    val aluno5 = Aluno("Nala")
    val aluno6 = Aluno("Luna")

    val conteudo1 = ConteudoEducacional("Introdução à programação", 10, Nivel.BASICO)
    val conteudo2 = ConteudoEducacional("Algoritmos e Logica", 20, Nivel.BASICO)
    val conteudo3 = ConteudoEducacional("Estrutura de dados", 15, Nivel.INTERMEDIARIO)
    val conteudo4 = ConteudoEducacional("Html", 15, Nivel.BASICO)
    val conteudo5 = ConteudoEducacional("Estatistica", 18, Nivel.AVANCADO)
    val conteudo6 = ConteudoEducacional("CSS", 16, Nivel.BASICO)
    val conteudo7 = ConteudoEducacional("Java Script", 30, Nivel.INTERMEDIARIO)
    val conteudo8 = ConteudoEducacional("Java", 30, Nivel.INTERMEDIARIO)
    val conteudo9 = ConteudoEducacional("Node", 30, Nivel.BASICO)
    val conteudo10 = ConteudoEducacional("Spring Boot Java", 10, Nivel.INTERMEDIARIO)
    val conteudo11 = ConteudoEducacional("React", 10, Nivel.INTERMEDIARIO)
    val conteudo12 = ConteudoEducacional("API RREST", 10, Nivel.INTERMEDIARIO)
    val conteudo13 = ConteudoEducacional("Tratamento de dados - ELT", 10, Nivel.AVANCADO)
    val conteudo14 = ConteudoEducacional("Python", 10, Nivel.AVANCADO)
    val conteudo15 = ConteudoEducacional("Docker", 10, Nivel.INTERMEDIARIO)    

    val formacao1 = Formacao("Front-End", listOf(conteudo1, conteudo4, conteudo6, conteudo7, conteudo8, conteudo10))
    val formacao2 = Formacao("Back-End", listOf(conteudo1, conteudo2, conteudo3, conteudo8, conteudo9, conteudo10, conteudo12, conteudo15))
    val formacao3 = Formacao("Full Stack", listOf(conteudo1, conteudo2, conteudo3, conteudo4, conteudo6, conteudo7, conteudo11, conteudo8, conteudo9))
    val formacao4 = Formacao("Data Analitics", listOf(conteudo2, conteudo3, conteudo5, conteudo13, conteudo14))
    val formacao5 = Formacao("Tester", listOf(conteudo14, conteudo1))
    
    formacao1.matricular(aluno1)
   
    formacao1.matricular(aluno1, aluno2, aluno3, aluno4)
    formacao2.matricular(aluno1, aluno4)
    formacao3.matricular(aluno5)
    formacao4.matricular(aluno2, aluno3, aluno5, aluno1, aluno4)

    println(formacao1.inscritos)

    formacao1.desmatricular(aluno1)
    formacao3.desmatricular(aluno1)
    formacao4.desmatricular(aluno3, aluno4)
    
    formacao5.matricular(aluno6)
      
    println("Formacao1:" + formacao1.inscritos)
    println("Formacao2:" + formacao2.inscritos)
    println("Formacao3:" + formacao3.inscritos)
    println("Formacao4:" + formacao4.inscritos)
    println("######### Detalhes de nivel #########")
    println("Nivel da formacao 1: " + formacao1.getNivel())
    println("Nivel da formacao 2: " + formacao2.getNivel())
    println("Nivel da formacao 3: " + formacao3.getNivel())
    println("Nivel da formacao 4: " + formacao4.getNivel())
    println("Nivel da formacao 4: " + formacao4.getNivel())
    
}