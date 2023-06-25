package com.pedrolemoz.academic;

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
import java.time.ZoneId;

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
        // Course
        var compSci = new CourseModel();
        compSci.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        coursesService.save(compSci);

        // Teachers
        var otavioAlcantaraDeLimaJunior = new TeacherModel();
        otavioAlcantaraDeLimaJunior.setName("OTAVIO ALCANTARA DE LIMA JUNIOR");
        otavioAlcantaraDeLimaJunior.setDocumentNumber("46524234545");
        teachersService.save(otavioAlcantaraDeLimaJunior);

        var fabioJoseGomesDeSousa = new TeacherModel();
        fabioJoseGomesDeSousa.setName("FABIO JOSÉ GOMES DE SOUSA");
        fabioJoseGomesDeSousa.setDocumentNumber("18256605731");
        teachersService.save(fabioJoseGomesDeSousa);

        var ciceroErialdoOliveiraLima = new TeacherModel();
        ciceroErialdoOliveiraLima.setName("CICERO ERIALDO OLIVEIRA LIMA");
        ciceroErialdoOliveiraLima.setDocumentNumber("23427420370");
        teachersService.save(ciceroErialdoOliveiraLima);

        var genilsonGomesDaSilva = new TeacherModel();
        genilsonGomesDaSilva.setName("GENILSON GOMES DA SILVA");
        genilsonGomesDaSilva.setDocumentNumber("73081453364");
        teachersService.save(genilsonGomesDaSilva);

        var joaoClaudioNunesCarvalho = new TeacherModel();
        joaoClaudioNunesCarvalho.setName("JOÃO CLAUDIO NUNES CARVALHO");
        joaoClaudioNunesCarvalho.setDocumentNumber("85871113613");
        teachersService.save(joaoClaudioNunesCarvalho);

        var joseRodriguesDoNascimentoNeto = new TeacherModel();
        joseRodriguesDoNascimentoNeto.setName("JOSE RODRIGUES DO NASCIMENTO NETO");
        joseRodriguesDoNascimentoNeto.setDocumentNumber("40063711281");
        teachersService.save(joseRodriguesDoNascimentoNeto);

        var danielSilvaFerreira = new TeacherModel();
        danielSilvaFerreira.setName("DANIEL SILVA FERREIRA");
        danielSilvaFerreira.setDocumentNumber("60544231180");
        teachersService.save(danielSilvaFerreira);

        var carlosHenriqueLeitaoCavalcante = new TeacherModel();
        carlosHenriqueLeitaoCavalcante.setName("CARLOS HENRIQUE LEITÃO CAVALCANTE");
        carlosHenriqueLeitaoCavalcante.setDocumentNumber("43728513407");
        teachersService.save(carlosHenriqueLeitaoCavalcante);

        var carlosHenriqueLima = new TeacherModel();
        carlosHenriqueLima.setName("CARLOS HENRIQUE LIMA");
        carlosHenriqueLima.setDocumentNumber("83468857098");
        teachersService.save(carlosHenriqueLima);

        var marcosCirineuAguiarSiqueira = new TeacherModel();
        marcosCirineuAguiarSiqueira.setName("MARCOS CIRINEU AGUIAR SIQUEIRA");
        marcosCirineuAguiarSiqueira.setDocumentNumber("01501061658");
        teachersService.save(marcosCirineuAguiarSiqueira);

        var adrianoTavaresDeFreitas = new TeacherModel();
        adrianoTavaresDeFreitas.setName("ADRIANO TAVARES DE FREITAS");
        adrianoTavaresDeFreitas.setDocumentNumber("88448420845");
        teachersService.save(adrianoTavaresDeFreitas);

        var igorRafaelSilvaValente = new TeacherModel();
        igorRafaelSilvaValente.setName("IGOR RAFAEL SILVA VALENTE");
        igorRafaelSilvaValente.setDocumentNumber("72648276580");
        teachersService.save(igorRafaelSilvaValente);

        var danielAlencarBarrosTavares = new TeacherModel();
        danielAlencarBarrosTavares.setName("DANIEL ALENCAR BARROS TAVARES");
        danielAlencarBarrosTavares.setDocumentNumber("63500582834");
        teachersService.save(danielAlencarBarrosTavares);

        var jeanMarceloDaSilvaMaciel = new TeacherModel();
        jeanMarceloDaSilvaMaciel.setName("JEAN MARCELO DA SILVA MACIEL");
        jeanMarceloDaSilvaMaciel.setDocumentNumber("01574518879");
        teachersService.save(jeanMarceloDaSilvaMaciel);

        var franciscoIcaroMacielForteChaves = new TeacherModel();
        franciscoIcaroMacielForteChaves.setName("FRANCISCO ICARO MACIEL FORTE CHAVES");
        franciscoIcaroMacielForteChaves.setDocumentNumber("12122368152");
        teachersService.save(franciscoIcaroMacielForteChaves);

        var inacioCordeiroAlves = new TeacherModel();
        inacioCordeiroAlves.setName("INACIO CORDEIRO ALVES");
        inacioCordeiroAlves.setDocumentNumber("38658155021");
        teachersService.save(inacioCordeiroAlves);

        var thiagoAlvesRocha = new TeacherModel();
        thiagoAlvesRocha.setName("THIAGO ALVES ROCHA");
        thiagoAlvesRocha.setDocumentNumber("53058062834");
        teachersService.save(thiagoAlvesRocha);

        var sandyFerreiraDaCostaBezerra = new TeacherModel();
        sandyFerreiraDaCostaBezerra.setName("SANDY FERREIRA DA COSTA BEZERRA");
        sandyFerreiraDaCostaBezerra.setDocumentNumber("42211840868");
        teachersService.save(sandyFerreiraDaCostaBezerra);

        var darielsonAraujoDeSouza = new TeacherModel();
        darielsonAraujoDeSouza.setName("DARIELSON ARAÚJO DE SOUZA");
        darielsonAraujoDeSouza.setDocumentNumber("31540778711");
        teachersService.save(darielsonAraujoDeSouza);

        var elderDosSantosTeixeira = new TeacherModel();
        elderDosSantosTeixeira.setName("ELDER DOS SANTOS TEIXEIRA");
        elderDosSantosTeixeira.setDocumentNumber("82335512102");
        teachersService.save(elderDosSantosTeixeira);

        var teachers = teachersService.findAll();

        for (TeacherModel teacher : teachers) {
            teacher.setBirthDate(LocalDateTime.now());
            teacher.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
            teachersService.save(teacher);
        }

        // Disciplines
        var calculoI = new DisciplineModel();
        calculoI.setName("CAL - I - CALCULO I");
        calculoI.setTeacher(franciscoIcaroMacielForteChaves);
        disciplinesService.save(calculoI);

        var circuitosDigitais = new DisciplineModel();
        circuitosDigitais.setName("CIRDIG - CIRCUITOS DIGITAIS");
        circuitosDigitais.setTeacher(otavioAlcantaraDeLimaJunior);
        disciplinesService.save(circuitosDigitais);

        var fundamentosDeProgramacao = new DisciplineModel();
        fundamentosDeProgramacao.setName("FUNPROG - FUNDAMENTOS DE PROGRAMAÇÃO");
        fundamentosDeProgramacao.setTeacher(fabioJoseGomesDeSousa);
        disciplinesService.save(fundamentosDeProgramacao);

        var matematicaDiscreta = new DisciplineModel();
        matematicaDiscreta.setName("MATDISC - MATEMATICA DISCRETA");
        matematicaDiscreta.setTeacher(ciceroErialdoOliveiraLima);
        disciplinesService.save(matematicaDiscreta);

        var algebraLinear = new DisciplineModel();
        algebraLinear.setName("ALGL - ALGEBRA LINEAR");
        algebraLinear.setTeacher(genilsonGomesDaSilva);
        disciplinesService.save(algebraLinear);

        var fisicaI = new DisciplineModel();
        fisicaI.setName("FIS - I - FÍSICA I");
        fisicaI.setTeacher(joaoClaudioNunesCarvalho);
        disciplinesService.save(fisicaI);

        var inglesInstrumental = new DisciplineModel();
        inglesInstrumental.setName("INGINST - INGLÊS INSTRUMENTAL");
        inglesInstrumental.setTeacher(joseRodriguesDoNascimentoNeto);
        disciplinesService.save(inglesInstrumental);

        var laboratorioDeProgramacao = new DisciplineModel();
        laboratorioDeProgramacao.setName("LABPROG - LABORATÓRIO DE PROGRAMAÇÃO");
        laboratorioDeProgramacao.setTeacher(danielSilvaFerreira);
        disciplinesService.save(laboratorioDeProgramacao);

        var arquiteturaDeComputadores = new DisciplineModel();
        arquiteturaDeComputadores.setName("ARQCOMP - ARQUITETURA DE COMPUTADORES");
        arquiteturaDeComputadores.setTeacher(carlosHenriqueLeitaoCavalcante);
        disciplinesService.save(arquiteturaDeComputadores);

        var fisicaIi = new DisciplineModel();
        fisicaIi.setName("FÍS II - FÍSICA II");
        fisicaIi.setTeacher(carlosHenriqueLima);
        disciplinesService.save(fisicaIi);

        var probabilidadeEEstatistica = new DisciplineModel();
        probabilidadeEEstatistica.setName("PEST - PROBABILIDADE E ESTATÍSTICA");
        probabilidadeEEstatistica.setTeacher(marcosCirineuAguiarSiqueira);
        disciplinesService.save(probabilidadeEEstatistica);

        var programacaoLinear = new DisciplineModel();
        programacaoLinear.setName("PLIN - PROGRAMAÇÃO LINEAR");
        programacaoLinear.setTeacher(adrianoTavaresDeFreitas);
        disciplinesService.save(programacaoLinear);

        var programacaoOrientadaAObjeto = new DisciplineModel();
        programacaoOrientadaAObjeto.setName("POO - PROGRAMAÇÃO ORIENTADA A OBJETO");
        programacaoOrientadaAObjeto.setTeacher(igorRafaelSilvaValente);
        disciplinesService.save(programacaoOrientadaAObjeto);

        var bancoDeDados = new DisciplineModel();
        bancoDeDados.setName("BD - BANCO DE DADOS");
        bancoDeDados.setTeacher(danielAlencarBarrosTavares);
        disciplinesService.save(bancoDeDados);

        var comunicacaoDeDados = new DisciplineModel();
        comunicacaoDeDados.setName("CDAD - COMUNICAÇÃO DE DADOS");
        comunicacaoDeDados.setTeacher(jeanMarceloDaSilvaMaciel);
        disciplinesService.save(comunicacaoDeDados);

        var calculoNumerico = new DisciplineModel();
        calculoNumerico.setName("CNUM - CALCULO NUMÉRICO");
        calculoNumerico.setTeacher(franciscoIcaroMacielForteChaves);
        disciplinesService.save(calculoNumerico);

        var estruturaDeDados = new DisciplineModel();
        estruturaDeDados.setName("ESTD - ESTRUTURA DE DADOS");
        estruturaDeDados.setTeacher(inacioCordeiroAlves);
        disciplinesService.save(estruturaDeDados);

        var logicaParaComputacao = new DisciplineModel();
        logicaParaComputacao.setName("LCOMP - LÓGICA PARA COMPUTAÇÃO");
        logicaParaComputacao.setTeacher(thiagoAlvesRocha);
        disciplinesService.save(logicaParaComputacao);

        var analiseDeAlgoritmos = new DisciplineModel();
        analiseDeAlgoritmos.setName("ANALG - ANALISE DE ALGORITMOS");
        analiseDeAlgoritmos.setTeacher(adrianoTavaresDeFreitas);
        disciplinesService.save(analiseDeAlgoritmos);

        var engenhariaDeSoftware = new DisciplineModel();
        engenhariaDeSoftware.setName("ENGS - ENGENHARIA DE SOFTWARE");
        engenhariaDeSoftware.setTeacher(sandyFerreiraDaCostaBezerra);
        disciplinesService.save(engenhariaDeSoftware);

        var grafos = new DisciplineModel();
        grafos.setName("GRAFOS - GRAFOS");
        grafos.setTeacher(darielsonAraujoDeSouza);
        disciplinesService.save(grafos);

        var introducaoAEletricidadeEEletronicaParaComputacao = new DisciplineModel();
        introducaoAEletricidadeEEletronicaParaComputacao.setName("IEEC - INTRODUÇÃO A ELETRICIDADE E ELETRÔNICA PARA COMPUTAÇÃO");
        introducaoAEletricidadeEEletronicaParaComputacao.setTeacher(elderDosSantosTeixeira);
        disciplinesService.save(introducaoAEletricidadeEEletronicaParaComputacao);

        var sistemasOperacionais = new DisciplineModel();
        sistemasOperacionais.setName("SO - SISTEMAS OPERACIONAIS");
        sistemasOperacionais.setTeacher(danielSilvaFerreira);
        disciplinesService.save(sistemasOperacionais);

        var disciplines = disciplinesService.findAll();

        for (DisciplineModel discipline : disciplines) {
            discipline.setYear(2023);
            discipline.setSemester(1);
            discipline.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
            discipline.setCourse(compSci);
            disciplinesService.save(discipline);
        }
    }
}
