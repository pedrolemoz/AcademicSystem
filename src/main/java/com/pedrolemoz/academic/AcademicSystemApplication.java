package com.pedrolemoz.academic;

import com.pedrolemoz.academic.enumerators.Degree;
import com.pedrolemoz.academic.models.CourseModel;
import com.pedrolemoz.academic.models.DisciplineModel;
import com.pedrolemoz.academic.models.TeacherModel;
import com.pedrolemoz.academic.services.CoursesService;
import com.pedrolemoz.academic.services.DisciplinesService;
import com.pedrolemoz.academic.services.StudentsService;
import com.pedrolemoz.academic.services.TeachersService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class AcademicSystemApplication implements CommandLineRunner {
    private final CoursesService coursesService;
    private final DisciplinesService disciplinesService;
    private final TeachersService teachersService;
    private final StudentsService studentsService;

    public AcademicSystemApplication(
            CoursesService coursesService,
            DisciplinesService disciplinesService,
            TeachersService teachersService,
            StudentsService studentsService
    ) {
        this.coursesService = coursesService;
        this.disciplinesService = disciplinesService;
        this.teachersService = teachersService;
        this.studentsService = studentsService;
    }

    public static void main(String[] args) {
        SpringApplication.run(AcademicSystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        var courses = coursesService.findAll();

        if (!courses.isEmpty()) {
            return;
        }

        // Course
        var compSci = new CourseModel();
        compSci.setRegistrationDate(LocalDateTime.parse("2023-06-25T19:13"));
        compSci.setName("CIÊNCIA DA COMPUTAÇÃO");
        compSci.setDegree(Degree.Bachelor);
        coursesService.save(compSci);

        // Teachers
        var otavioAlcantaraDeLimaJunior = new TeacherModel();
        otavioAlcantaraDeLimaJunior.setName("OTAVIO ALCANTARA DE LIMA JUNIOR");
        otavioAlcantaraDeLimaJunior.setDocumentNumber("46524234545");
        otavioAlcantaraDeLimaJunior.setBirthDate(LocalDateTime.parse("2023-06-25T19:13"));
        otavioAlcantaraDeLimaJunior.setRegistrationDate(LocalDateTime.parse("2023-06-25T19:13"));
        teachersService.save(otavioAlcantaraDeLimaJunior);

        var fabioJoseGomesDeSousa = new TeacherModel();
        fabioJoseGomesDeSousa.setName("FABIO JOSÉ GOMES DE SOUSA");
        fabioJoseGomesDeSousa.setDocumentNumber("18256605731");
        fabioJoseGomesDeSousa.setBirthDate(LocalDateTime.parse("2023-06-25T19:13"));
        fabioJoseGomesDeSousa.setRegistrationDate(LocalDateTime.parse("2023-06-25T19:13"));
        teachersService.save(fabioJoseGomesDeSousa);

        var ciceroErialdoOliveiraLima = new TeacherModel();
        ciceroErialdoOliveiraLima.setName("CICERO ERIALDO OLIVEIRA LIMA");
        ciceroErialdoOliveiraLima.setDocumentNumber("23427420370");
        ciceroErialdoOliveiraLima.setBirthDate(LocalDateTime.parse("2023-06-25T19:13"));
        ciceroErialdoOliveiraLima.setRegistrationDate(LocalDateTime.parse("2023-06-25T19:13"));
        teachersService.save(ciceroErialdoOliveiraLima);

        var genilsonGomesDaSilva = new TeacherModel();
        genilsonGomesDaSilva.setName("GENILSON GOMES DA SILVA");
        genilsonGomesDaSilva.setDocumentNumber("73081453364");
        genilsonGomesDaSilva.setBirthDate(LocalDateTime.parse("2023-06-25T19:13"));
        genilsonGomesDaSilva.setRegistrationDate(LocalDateTime.parse("2023-06-25T19:13"));
        teachersService.save(genilsonGomesDaSilva);

        var joaoClaudioNunesCarvalho = new TeacherModel();
        joaoClaudioNunesCarvalho.setName("JOÃO CLAUDIO NUNES CARVALHO");
        joaoClaudioNunesCarvalho.setDocumentNumber("85871113613");
        joaoClaudioNunesCarvalho.setBirthDate(LocalDateTime.parse("2023-06-25T19:13"));
        joaoClaudioNunesCarvalho.setRegistrationDate(LocalDateTime.parse("2023-06-25T19:13"));
        teachersService.save(joaoClaudioNunesCarvalho);

        var joseRodriguesDoNascimentoNeto = new TeacherModel();
        joseRodriguesDoNascimentoNeto.setName("JOSE RODRIGUES DO NASCIMENTO NETO");
        joseRodriguesDoNascimentoNeto.setDocumentNumber("40063711281");
        joseRodriguesDoNascimentoNeto.setBirthDate(LocalDateTime.parse("2023-06-25T19:13"));
        joseRodriguesDoNascimentoNeto.setRegistrationDate(LocalDateTime.parse("2023-06-25T19:13"));
        teachersService.save(joseRodriguesDoNascimentoNeto);

        var danielSilvaFerreira = new TeacherModel();
        danielSilvaFerreira.setName("DANIEL SILVA FERREIRA");
        danielSilvaFerreira.setDocumentNumber("60544231180");
        danielSilvaFerreira.setBirthDate(LocalDateTime.parse("2023-06-25T19:13"));
        danielSilvaFerreira.setRegistrationDate(LocalDateTime.parse("2023-06-25T19:13"));
        teachersService.save(danielSilvaFerreira);

        var carlosHenriqueLeitaoCavalcante = new TeacherModel();
        carlosHenriqueLeitaoCavalcante.setName("CARLOS HENRIQUE LEITÃO CAVALCANTE");
        carlosHenriqueLeitaoCavalcante.setDocumentNumber("43728513407");
        carlosHenriqueLeitaoCavalcante.setBirthDate(LocalDateTime.parse("2023-06-25T19:13"));
        carlosHenriqueLeitaoCavalcante.setRegistrationDate(LocalDateTime.parse("2023-06-25T19:13"));
        teachersService.save(carlosHenriqueLeitaoCavalcante);

        var carlosHenriqueLima = new TeacherModel();
        carlosHenriqueLima.setName("CARLOS HENRIQUE LIMA");
        carlosHenriqueLima.setDocumentNumber("83468857098");
        carlosHenriqueLima.setBirthDate(LocalDateTime.parse("2023-06-25T19:13"));
        carlosHenriqueLima.setRegistrationDate(LocalDateTime.parse("2023-06-25T19:13"));
        teachersService.save(carlosHenriqueLima);

        var marcosCirineuAguiarSiqueira = new TeacherModel();
        marcosCirineuAguiarSiqueira.setName("MARCOS CIRINEU AGUIAR SIQUEIRA");
        marcosCirineuAguiarSiqueira.setDocumentNumber("01501061658");
        marcosCirineuAguiarSiqueira.setBirthDate(LocalDateTime.parse("2023-06-25T19:13"));
        marcosCirineuAguiarSiqueira.setRegistrationDate(LocalDateTime.parse("2023-06-25T19:13"));
        teachersService.save(marcosCirineuAguiarSiqueira);

        var adrianoTavaresDeFreitas = new TeacherModel();
        adrianoTavaresDeFreitas.setName("ADRIANO TAVARES DE FREITAS");
        adrianoTavaresDeFreitas.setDocumentNumber("88448420845");
        adrianoTavaresDeFreitas.setBirthDate(LocalDateTime.parse("2023-06-25T19:13"));
        adrianoTavaresDeFreitas.setRegistrationDate(LocalDateTime.parse("2023-06-25T19:13"));
        teachersService.save(adrianoTavaresDeFreitas);

        var igorRafaelSilvaValente = new TeacherModel();
        igorRafaelSilvaValente.setName("IGOR RAFAEL SILVA VALENTE");
        igorRafaelSilvaValente.setDocumentNumber("72648276580");
        igorRafaelSilvaValente.setBirthDate(LocalDateTime.parse("2023-06-25T19:13"));
        igorRafaelSilvaValente.setRegistrationDate(LocalDateTime.parse("2023-06-25T19:13"));
        teachersService.save(igorRafaelSilvaValente);

        var danielAlencarBarrosTavares = new TeacherModel();
        danielAlencarBarrosTavares.setName("DANIEL ALENCAR BARROS TAVARES");
        danielAlencarBarrosTavares.setDocumentNumber("63500582834");
        danielAlencarBarrosTavares.setBirthDate(LocalDateTime.parse("2023-06-25T19:13"));
        danielAlencarBarrosTavares.setRegistrationDate(LocalDateTime.parse("2023-06-25T19:13"));
        teachersService.save(danielAlencarBarrosTavares);

        var jeanMarceloDaSilvaMaciel = new TeacherModel();
        jeanMarceloDaSilvaMaciel.setName("JEAN MARCELO DA SILVA MACIEL");
        jeanMarceloDaSilvaMaciel.setDocumentNumber("01574518879");
        jeanMarceloDaSilvaMaciel.setBirthDate(LocalDateTime.parse("2023-06-25T19:13"));
        jeanMarceloDaSilvaMaciel.setRegistrationDate(LocalDateTime.parse("2023-06-25T19:13"));
        teachersService.save(jeanMarceloDaSilvaMaciel);

        var franciscoIcaroMacielForteChaves = new TeacherModel();
        franciscoIcaroMacielForteChaves.setName("FRANCISCO ICARO MACIEL FORTE CHAVES");
        franciscoIcaroMacielForteChaves.setDocumentNumber("12122368152");
        franciscoIcaroMacielForteChaves.setBirthDate(LocalDateTime.parse("2023-06-25T19:13"));
        franciscoIcaroMacielForteChaves.setRegistrationDate(LocalDateTime.parse("2023-06-25T19:13"));
        teachersService.save(franciscoIcaroMacielForteChaves);

        var inacioCordeiroAlves = new TeacherModel();
        inacioCordeiroAlves.setName("INACIO CORDEIRO ALVES");
        inacioCordeiroAlves.setDocumentNumber("38658155021");
        inacioCordeiroAlves.setBirthDate(LocalDateTime.parse("2023-06-25T19:13"));
        inacioCordeiroAlves.setRegistrationDate(LocalDateTime.parse("2023-06-25T19:13"));
        teachersService.save(inacioCordeiroAlves);

        var thiagoAlvesRocha = new TeacherModel();
        thiagoAlvesRocha.setName("THIAGO ALVES ROCHA");
        thiagoAlvesRocha.setDocumentNumber("53058062834");
        thiagoAlvesRocha.setBirthDate(LocalDateTime.parse("2023-06-25T19:13"));
        thiagoAlvesRocha.setRegistrationDate(LocalDateTime.parse("2023-06-25T19:13"));
        teachersService.save(thiagoAlvesRocha);

        var sandyFerreiraDaCostaBezerra = new TeacherModel();
        sandyFerreiraDaCostaBezerra.setName("SANDY FERREIRA DA COSTA BEZERRA");
        sandyFerreiraDaCostaBezerra.setDocumentNumber("42211840868");
        sandyFerreiraDaCostaBezerra.setBirthDate(LocalDateTime.parse("2023-06-25T19:13"));
        sandyFerreiraDaCostaBezerra.setRegistrationDate(LocalDateTime.parse("2023-06-25T19:13"));
        teachersService.save(sandyFerreiraDaCostaBezerra);

        var darielsonAraujoDeSouza = new TeacherModel();
        darielsonAraujoDeSouza.setName("DARIELSON ARAÚJO DE SOUZA");
        darielsonAraujoDeSouza.setDocumentNumber("31540778711");
        darielsonAraujoDeSouza.setBirthDate(LocalDateTime.parse("2023-06-25T19:13"));
        darielsonAraujoDeSouza.setRegistrationDate(LocalDateTime.parse("2023-06-25T19:13"));
        teachersService.save(darielsonAraujoDeSouza);

        var elderDosSantosTeixeira = new TeacherModel();
        elderDosSantosTeixeira.setName("ELDER DOS SANTOS TEIXEIRA");
        elderDosSantosTeixeira.setDocumentNumber("82335512102");
        elderDosSantosTeixeira.setBirthDate(LocalDateTime.parse("2023-06-25T19:13"));
        elderDosSantosTeixeira.setRegistrationDate(LocalDateTime.parse("2023-06-25T19:13"));
        teachersService.save(elderDosSantosTeixeira);


        // Disciplines
        var calculoI = new DisciplineModel();
        calculoI.setName("CAL - I - CALCULO I");
        calculoI.setTeacher(franciscoIcaroMacielForteChaves);
        calculoI.setYear(2023);
        calculoI.setSemester(1);
        calculoI.setRegistrationDate(LocalDateTime.parse("2023-06-25T19:13"));
        calculoI.setCourse(compSci);
        disciplinesService.save(calculoI);

        var circuitosDigitais = new DisciplineModel();
        circuitosDigitais.setName("CIRDIG - CIRCUITOS DIGITAIS");
        circuitosDigitais.setTeacher(otavioAlcantaraDeLimaJunior);
        circuitosDigitais.setYear(2023);
        circuitosDigitais.setSemester(1);
        circuitosDigitais.setRegistrationDate(LocalDateTime.parse("2023-06-25T19:13"));
        circuitosDigitais.setCourse(compSci);
        disciplinesService.save(circuitosDigitais);

        var fundamentosDeProgramacao = new DisciplineModel();
        fundamentosDeProgramacao.setName("FUNPROG - FUNDAMENTOS DE PROGRAMAÇÃO");
        fundamentosDeProgramacao.setTeacher(fabioJoseGomesDeSousa);
        fundamentosDeProgramacao.setYear(2023);
        fundamentosDeProgramacao.setSemester(1);
        fundamentosDeProgramacao.setRegistrationDate(LocalDateTime.parse("2023-06-25T19:13"));
        fundamentosDeProgramacao.setCourse(compSci);
        disciplinesService.save(fundamentosDeProgramacao);

        var matematicaDiscreta = new DisciplineModel();
        matematicaDiscreta.setName("MATDISC - MATEMATICA DISCRETA");
        matematicaDiscreta.setTeacher(ciceroErialdoOliveiraLima);
        matematicaDiscreta.setYear(2023);
        matematicaDiscreta.setSemester(1);
        matematicaDiscreta.setRegistrationDate(LocalDateTime.parse("2023-06-25T19:13"));
        matematicaDiscreta.setCourse(compSci);
        disciplinesService.save(matematicaDiscreta);

        var algebraLinear = new DisciplineModel();
        algebraLinear.setName("ALGL - ALGEBRA LINEAR");
        algebraLinear.setTeacher(genilsonGomesDaSilva);
        algebraLinear.setYear(2023);
        algebraLinear.setSemester(1);
        algebraLinear.setRegistrationDate(LocalDateTime.parse("2023-06-25T19:13"));
        algebraLinear.setCourse(compSci);
        disciplinesService.save(algebraLinear);

        var fisicaI = new DisciplineModel();
        fisicaI.setName("FIS - I - FÍSICA I");
        fisicaI.setTeacher(joaoClaudioNunesCarvalho);
        fisicaI.setYear(2023);
        fisicaI.setSemester(1);
        fisicaI.setRegistrationDate(LocalDateTime.parse("2023-06-25T19:13"));
        fisicaI.setCourse(compSci);
        disciplinesService.save(fisicaI);

        var inglesInstrumental = new DisciplineModel();
        inglesInstrumental.setName("INGINST - INGLÊS INSTRUMENTAL");
        inglesInstrumental.setTeacher(joseRodriguesDoNascimentoNeto);
        inglesInstrumental.setYear(2023);
        inglesInstrumental.setSemester(1);
        inglesInstrumental.setRegistrationDate(LocalDateTime.parse("2023-06-25T19:13"));
        inglesInstrumental.setCourse(compSci);
        disciplinesService.save(inglesInstrumental);

        var laboratorioDeProgramacao = new DisciplineModel();
        laboratorioDeProgramacao.setName("LABPROG - LABORATÓRIO DE PROGRAMAÇÃO");
        laboratorioDeProgramacao.setTeacher(danielSilvaFerreira);
        laboratorioDeProgramacao.setYear(2023);
        laboratorioDeProgramacao.setSemester(1);
        laboratorioDeProgramacao.setRegistrationDate(LocalDateTime.parse("2023-06-25T19:13"));
        laboratorioDeProgramacao.setCourse(compSci);
        disciplinesService.save(laboratorioDeProgramacao);

        var arquiteturaDeComputadores = new DisciplineModel();
        arquiteturaDeComputadores.setName("ARQCOMP - ARQUITETURA DE COMPUTADORES");
        arquiteturaDeComputadores.setTeacher(carlosHenriqueLeitaoCavalcante);
        arquiteturaDeComputadores.setYear(2023);
        arquiteturaDeComputadores.setSemester(1);
        arquiteturaDeComputadores.setRegistrationDate(LocalDateTime.parse("2023-06-25T19:13"));
        arquiteturaDeComputadores.setCourse(compSci);
        disciplinesService.save(arquiteturaDeComputadores);

        var fisicaIi = new DisciplineModel();
        fisicaIi.setName("FÍS II - FÍSICA II");
        fisicaIi.setTeacher(carlosHenriqueLima);
        fisicaIi.setYear(2023);
        fisicaIi.setSemester(1);
        fisicaIi.setRegistrationDate(LocalDateTime.parse("2023-06-25T19:13"));
        fisicaIi.setCourse(compSci);
        disciplinesService.save(fisicaIi);

        var probabilidadeEEstatistica = new DisciplineModel();
        probabilidadeEEstatistica.setName("PEST - PROBABILIDADE E ESTATÍSTICA");
        probabilidadeEEstatistica.setTeacher(marcosCirineuAguiarSiqueira);
        probabilidadeEEstatistica.setYear(2023);
        probabilidadeEEstatistica.setSemester(1);
        probabilidadeEEstatistica.setRegistrationDate(LocalDateTime.parse("2023-06-25T19:13"));
        probabilidadeEEstatistica.setCourse(compSci);
        disciplinesService.save(probabilidadeEEstatistica);

        var programacaoLinear = new DisciplineModel();
        programacaoLinear.setName("PLIN - PROGRAMAÇÃO LINEAR");
        programacaoLinear.setTeacher(adrianoTavaresDeFreitas);
        programacaoLinear.setYear(2023);
        programacaoLinear.setSemester(1);
        programacaoLinear.setRegistrationDate(LocalDateTime.parse("2023-06-25T19:13"));
        programacaoLinear.setCourse(compSci);
        disciplinesService.save(programacaoLinear);

        var programacaoOrientadaAObjeto = new DisciplineModel();
        programacaoOrientadaAObjeto.setName("POO - PROGRAMAÇÃO ORIENTADA A OBJETO");
        programacaoOrientadaAObjeto.setTeacher(igorRafaelSilvaValente);
        programacaoOrientadaAObjeto.setYear(2023);
        programacaoOrientadaAObjeto.setSemester(1);
        programacaoOrientadaAObjeto.setRegistrationDate(LocalDateTime.parse("2023-06-25T19:13"));
        programacaoOrientadaAObjeto.setCourse(compSci);
        disciplinesService.save(programacaoOrientadaAObjeto);

        var bancoDeDados = new DisciplineModel();
        bancoDeDados.setName("BD - BANCO DE DADOS");
        bancoDeDados.setTeacher(danielAlencarBarrosTavares);
        bancoDeDados.setYear(2023);
        bancoDeDados.setSemester(1);
        bancoDeDados.setRegistrationDate(LocalDateTime.parse("2023-06-25T19:13"));
        bancoDeDados.setCourse(compSci);
        disciplinesService.save(bancoDeDados);

        var comunicacaoDeDados = new DisciplineModel();
        comunicacaoDeDados.setName("CDAD - COMUNICAÇÃO DE DADOS");
        comunicacaoDeDados.setTeacher(jeanMarceloDaSilvaMaciel);
        comunicacaoDeDados.setYear(2023);
        comunicacaoDeDados.setSemester(1);
        comunicacaoDeDados.setRegistrationDate(LocalDateTime.parse("2023-06-25T19:13"));
        comunicacaoDeDados.setCourse(compSci);
        disciplinesService.save(comunicacaoDeDados);

        var calculoNumerico = new DisciplineModel();
        calculoNumerico.setName("CNUM - CALCULO NUMÉRICO");
        calculoNumerico.setTeacher(franciscoIcaroMacielForteChaves);
        calculoNumerico.setYear(2023);
        calculoNumerico.setSemester(1);
        calculoNumerico.setRegistrationDate(LocalDateTime.parse("2023-06-25T19:13"));
        calculoNumerico.setCourse(compSci);
        disciplinesService.save(calculoNumerico);

        var estruturaDeDados = new DisciplineModel();
        estruturaDeDados.setName("ESTD - ESTRUTURA DE DADOS");
        estruturaDeDados.setTeacher(inacioCordeiroAlves);
        estruturaDeDados.setYear(2023);
        estruturaDeDados.setSemester(1);
        estruturaDeDados.setRegistrationDate(LocalDateTime.parse("2023-06-25T19:13"));
        estruturaDeDados.setCourse(compSci);
        disciplinesService.save(estruturaDeDados);

        var logicaParaComputacao = new DisciplineModel();
        logicaParaComputacao.setName("LCOMP - LÓGICA PARA COMPUTAÇÃO");
        logicaParaComputacao.setTeacher(thiagoAlvesRocha);
        logicaParaComputacao.setYear(2023);
        logicaParaComputacao.setSemester(1);
        logicaParaComputacao.setRegistrationDate(LocalDateTime.parse("2023-06-25T19:13"));
        logicaParaComputacao.setCourse(compSci);
        disciplinesService.save(logicaParaComputacao);

        var analiseDeAlgoritmos = new DisciplineModel();
        analiseDeAlgoritmos.setName("ANALG - ANALISE DE ALGORITMOS");
        analiseDeAlgoritmos.setTeacher(adrianoTavaresDeFreitas);
        analiseDeAlgoritmos.setYear(2023);
        analiseDeAlgoritmos.setSemester(1);
        analiseDeAlgoritmos.setRegistrationDate(LocalDateTime.parse("2023-06-25T19:13"));
        analiseDeAlgoritmos.setCourse(compSci);
        disciplinesService.save(analiseDeAlgoritmos);

        var engenhariaDeSoftware = new DisciplineModel();
        engenhariaDeSoftware.setName("ENGS - ENGENHARIA DE SOFTWARE");
        engenhariaDeSoftware.setTeacher(sandyFerreiraDaCostaBezerra);
        engenhariaDeSoftware.setYear(2023);
        engenhariaDeSoftware.setSemester(1);
        engenhariaDeSoftware.setRegistrationDate(LocalDateTime.parse("2023-06-25T19:13"));
        engenhariaDeSoftware.setCourse(compSci);
        disciplinesService.save(engenhariaDeSoftware);

        var grafos = new DisciplineModel();
        grafos.setName("GRAFOS - GRAFOS");
        grafos.setTeacher(darielsonAraujoDeSouza);
        grafos.setYear(2023);
        grafos.setSemester(1);
        grafos.setRegistrationDate(LocalDateTime.parse("2023-06-25T19:13"));
        grafos.setCourse(compSci);
        disciplinesService.save(grafos);

        var introducaoAEletricidadeEEletronicaParaComputacao = new DisciplineModel();
        introducaoAEletricidadeEEletronicaParaComputacao.setName("IEEC - INTRODUÇÃO A ELETRICIDADE E ELETRÔNICA PARA COMPUTAÇÃO");
        introducaoAEletricidadeEEletronicaParaComputacao.setTeacher(elderDosSantosTeixeira);
        introducaoAEletricidadeEEletronicaParaComputacao.setYear(2023);
        introducaoAEletricidadeEEletronicaParaComputacao.setSemester(1);
        introducaoAEletricidadeEEletronicaParaComputacao.setRegistrationDate(LocalDateTime.parse("2023-06-25T19:13"));
        introducaoAEletricidadeEEletronicaParaComputacao.setCourse(compSci);
        disciplinesService.save(introducaoAEletricidadeEEletronicaParaComputacao);

        var sistemasOperacionais = new DisciplineModel();
        sistemasOperacionais.setName("SO - SISTEMAS OPERACIONAIS");
        sistemasOperacionais.setTeacher(danielSilvaFerreira);
        sistemasOperacionais.setYear(2023);
        sistemasOperacionais.setSemester(1);
        sistemasOperacionais.setRegistrationDate(LocalDateTime.parse("2023-06-25T19:13"));
        sistemasOperacionais.setCourse(compSci);
        disciplinesService.save(sistemasOperacionais);
    }
}
