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
import java.util.ArrayList;
import java.util.List;

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

        // Teachers
        List<TeacherModel> teachers = new ArrayList<>();

        var otavioAlcantaraDeLimaJunior = new TeacherModel();
        otavioAlcantaraDeLimaJunior.setName("OTAVIO ALCANTARA DE LIMA JUNIOR");
        otavioAlcantaraDeLimaJunior.setDocumentNumber("46524234545");
        otavioAlcantaraDeLimaJunior.setBirthDate(LocalDateTime.now());
        otavioAlcantaraDeLimaJunior.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        teachersService.save(otavioAlcantaraDeLimaJunior);

        var fabioJoseGomesDeSousa = new TeacherModel();
        fabioJoseGomesDeSousa.setName("FABIO JOSÉ GOMES DE SOUSA");
        fabioJoseGomesDeSousa.setDocumentNumber("18256605731");
        fabioJoseGomesDeSousa.setBirthDate(LocalDateTime.now());
        fabioJoseGomesDeSousa.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        teachersService.save(fabioJoseGomesDeSousa);

        var ciceroErialdoOliveiraLima = new TeacherModel();
        ciceroErialdoOliveiraLima.setName("CICERO ERIALDO OLIVEIRA LIMA");
        ciceroErialdoOliveiraLima.setDocumentNumber("23427420370");
        ciceroErialdoOliveiraLima.setBirthDate(LocalDateTime.now());
        ciceroErialdoOliveiraLima.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        teachersService.save(ciceroErialdoOliveiraLima);

        var genilsonGomesDaSilva = new TeacherModel();
        genilsonGomesDaSilva.setName("GENILSON GOMES DA SILVA");
        genilsonGomesDaSilva.setDocumentNumber("73081453364");
        genilsonGomesDaSilva.setBirthDate(LocalDateTime.now());
        genilsonGomesDaSilva.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        teachersService.save(genilsonGomesDaSilva);

        var joaoClaudioNunesCarvalho = new TeacherModel();
        joaoClaudioNunesCarvalho.setName("JOÃO CLAUDIO NUNES CARVALHO");
        joaoClaudioNunesCarvalho.setDocumentNumber("85871113613");
        joaoClaudioNunesCarvalho.setBirthDate(LocalDateTime.now());
        joaoClaudioNunesCarvalho.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        teachersService.save(joaoClaudioNunesCarvalho);

        var joseRodriguesDoNascimentoNeto = new TeacherModel();
        joseRodriguesDoNascimentoNeto.setName("JOSE RODRIGUES DO NASCIMENTO NETO");
        joseRodriguesDoNascimentoNeto.setDocumentNumber("40063711281");
        joseRodriguesDoNascimentoNeto.setBirthDate(LocalDateTime.now());
        joseRodriguesDoNascimentoNeto.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        teachersService.save(joseRodriguesDoNascimentoNeto);

        var danielSilvaFerreira = new TeacherModel();
        danielSilvaFerreira.setName("DANIEL SILVA FERREIRA");
        danielSilvaFerreira.setDocumentNumber("60544231180");
        danielSilvaFerreira.setBirthDate(LocalDateTime.now());
        danielSilvaFerreira.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        teachersService.save(danielSilvaFerreira);

        var carlosHenriqueLeitaoCavalcante = new TeacherModel();
        carlosHenriqueLeitaoCavalcante.setName("CARLOS HENRIQUE LEITÃO CAVALCANTE");
        carlosHenriqueLeitaoCavalcante.setDocumentNumber("43728513407");
        carlosHenriqueLeitaoCavalcante.setBirthDate(LocalDateTime.now());
        carlosHenriqueLeitaoCavalcante.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        teachersService.save(carlosHenriqueLeitaoCavalcante);

        var carlosHenriqueLima = new TeacherModel();
        carlosHenriqueLima.setName("CARLOS HENRIQUE LIMA");
        carlosHenriqueLima.setDocumentNumber("83468857098");
        carlosHenriqueLima.setBirthDate(LocalDateTime.now());
        carlosHenriqueLima.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        teachersService.save(carlosHenriqueLima);

        var marcosCirineuAguiarSiqueira = new TeacherModel();
        marcosCirineuAguiarSiqueira.setName("MARCOS CIRINEU AGUIAR SIQUEIRA");
        marcosCirineuAguiarSiqueira.setDocumentNumber("01501061658");
        marcosCirineuAguiarSiqueira.setBirthDate(LocalDateTime.now());
        marcosCirineuAguiarSiqueira.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        teachersService.save(marcosCirineuAguiarSiqueira);

        var adrianoTavaresDeFreitas = new TeacherModel();
        adrianoTavaresDeFreitas.setName("ADRIANO TAVARES DE FREITAS");
        adrianoTavaresDeFreitas.setDocumentNumber("88448420845");
        adrianoTavaresDeFreitas.setBirthDate(LocalDateTime.now());
        adrianoTavaresDeFreitas.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        teachersService.save(adrianoTavaresDeFreitas);

        var igorRafaelSilvaValente = new TeacherModel();
        igorRafaelSilvaValente.setName("IGOR RAFAEL SILVA VALENTE");
        igorRafaelSilvaValente.setDocumentNumber("72648276580");
        igorRafaelSilvaValente.setBirthDate(LocalDateTime.now());
        igorRafaelSilvaValente.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        teachersService.save(igorRafaelSilvaValente);

        var danielAlencarBarrosTavares = new TeacherModel();
        danielAlencarBarrosTavares.setName("DANIEL ALENCAR BARROS TAVARES");
        danielAlencarBarrosTavares.setDocumentNumber("63500582834");
        danielAlencarBarrosTavares.setBirthDate(LocalDateTime.now());
        danielAlencarBarrosTavares.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        teachersService.save(danielAlencarBarrosTavares);

        var jeanMarceloDaSilvaMaciel = new TeacherModel();
        jeanMarceloDaSilvaMaciel.setName("JEAN MARCELO DA SILVA MACIEL");
        jeanMarceloDaSilvaMaciel.setDocumentNumber("01574518879");
        jeanMarceloDaSilvaMaciel.setBirthDate(LocalDateTime.now());
        jeanMarceloDaSilvaMaciel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        teachersService.save(jeanMarceloDaSilvaMaciel);

        var franciscoIcaroMacielForteChaves = new TeacherModel();
        franciscoIcaroMacielForteChaves.setName("FRANCISCO ICARO MACIEL FORTE CHAVES");
        franciscoIcaroMacielForteChaves.setDocumentNumber("12122368152");
        franciscoIcaroMacielForteChaves.setBirthDate(LocalDateTime.now());
        franciscoIcaroMacielForteChaves.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        teachersService.save(franciscoIcaroMacielForteChaves);

        var inacioCordeiroAlves = new TeacherModel();
        inacioCordeiroAlves.setName("INACIO CORDEIRO ALVES");
        inacioCordeiroAlves.setDocumentNumber("38658155021");
        inacioCordeiroAlves.setBirthDate(LocalDateTime.now());
        inacioCordeiroAlves.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        teachersService.save(inacioCordeiroAlves);

        var thiagoAlvesRocha = new TeacherModel();
        thiagoAlvesRocha.setName("THIAGO ALVES ROCHA");
        thiagoAlvesRocha.setDocumentNumber("53058062834");
        thiagoAlvesRocha.setBirthDate(LocalDateTime.now());
        thiagoAlvesRocha.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        teachersService.save(thiagoAlvesRocha);

        var sandyFerreiraDaCostaBezerra = new TeacherModel();
        sandyFerreiraDaCostaBezerra.setName("SANDY FERREIRA DA COSTA BEZERRA");
        sandyFerreiraDaCostaBezerra.setDocumentNumber("42211840868");
        sandyFerreiraDaCostaBezerra.setBirthDate(LocalDateTime.now());
        sandyFerreiraDaCostaBezerra.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        teachersService.save(sandyFerreiraDaCostaBezerra);

        var darielsonAraujoDeSouza = new TeacherModel();
        darielsonAraujoDeSouza.setName("DARIELSON ARAÚJO DE SOUZA");
        darielsonAraujoDeSouza.setDocumentNumber("31540778711");
        darielsonAraujoDeSouza.setBirthDate(LocalDateTime.now());
        darielsonAraujoDeSouza.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        teachersService.save(darielsonAraujoDeSouza);

        var elderDosSantosTeixeira = new TeacherModel();
        elderDosSantosTeixeira.setName("ELDER DOS SANTOS TEIXEIRA");
        elderDosSantosTeixeira.setDocumentNumber("82335512102");
        elderDosSantosTeixeira.setBirthDate(LocalDateTime.now());
        elderDosSantosTeixeira.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        teachersService.save(elderDosSantosTeixeira);

        // Disciplines
        List<DisciplineModel> disciplines = new ArrayList<>();

        var calculoI = new DisciplineModel();
        calculoI.setName("CAL - I - CALCULO I");
        calculoI.setYear(2023);
        calculoI.setSemester(1);
        calculoI.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        calculoI.setTeacher(franciscoIcaroMacielForteChaves);
        disciplinesService.save(calculoI);

        var circuitosDigitais = new DisciplineModel();
        circuitosDigitais.setName("CIRDIG - CIRCUITOS DIGITAIS");
        circuitosDigitais.setYear(2023);
        circuitosDigitais.setSemester(1);
        circuitosDigitais.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        circuitosDigitais.setTeacher(otavioAlcantaraDeLimaJunior);
        disciplinesService.save(circuitosDigitais);

        var fundamentosDeProgramacao = new DisciplineModel();
        fundamentosDeProgramacao.setName("FUNPROG - FUNDAMENTOS DE PROGRAMAÇÃO");
        fundamentosDeProgramacao.setYear(2023);
        fundamentosDeProgramacao.setSemester(1);
        fundamentosDeProgramacao.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        fundamentosDeProgramacao.setTeacher(fabioJoseGomesDeSousa);
        disciplinesService.save(fundamentosDeProgramacao);

        var matematicaDiscreta = new DisciplineModel();
        matematicaDiscreta.setName("MATDISC - MATEMATICA DISCRETA");
        matematicaDiscreta.setYear(2023);
        matematicaDiscreta.setSemester(1);
        matematicaDiscreta.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        matematicaDiscreta.setTeacher(ciceroErialdoOliveiraLima);
        disciplinesService.save(matematicaDiscreta);

        var algebraLinear = new DisciplineModel();
        algebraLinear.setName("ALGL - ALGEBRA LINEAR");
        algebraLinear.setYear(2023);
        algebraLinear.setSemester(1);
        algebraLinear.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        algebraLinear.setTeacher(genilsonGomesDaSilva);
        disciplinesService.save(algebraLinear);

        var fisicaI = new DisciplineModel();
        fisicaI.setName("FIS - I - FÍSICA I");
        fisicaI.setYear(2023);
        fisicaI.setSemester(1);
        fisicaI.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        fisicaI.setTeacher(joaoClaudioNunesCarvalho);
        disciplinesService.save(fisicaI);

        var inglesInstrumental = new DisciplineModel();
        inglesInstrumental.setName("INGINST - INGLÊS INSTRUMENTAL");
        inglesInstrumental.setYear(2023);
        inglesInstrumental.setSemester(1);
        inglesInstrumental.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        disciplinesService.save(inglesInstrumental);

        var laboratorioDeProgramacao = new DisciplineModel();
        laboratorioDeProgramacao.setName("LABPROG - LABORATÓRIO DE PROGRAMAÇÃO");
        laboratorioDeProgramacao.setYear(2023);
        laboratorioDeProgramacao.setSemester(1);
        laboratorioDeProgramacao.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        laboratorioDeProgramacao.setTeacher(danielSilvaFerreira);
        disciplinesService.save(laboratorioDeProgramacao);

        var arquiteturaDeComputadores = new DisciplineModel();
        arquiteturaDeComputadores.setName("ARQCOMP - ARQUITETURA DE COMPUTADORES");
        arquiteturaDeComputadores.setYear(2023);
        arquiteturaDeComputadores.setSemester(1);
        arquiteturaDeComputadores.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        arquiteturaDeComputadores.setTeacher(carlosHenriqueLeitaoCavalcante);
        disciplinesService.save(arquiteturaDeComputadores);

        var fisicaIi = new DisciplineModel();
        fisicaIi.setName("FÍS II - FÍSICA II");
        fisicaIi.setYear(2023);
        fisicaIi.setSemester(1);
        fisicaIi.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        disciplinesService.save(fisicaIi);

        var probabilidadeEEstatistica = new DisciplineModel();
        probabilidadeEEstatistica.setName("PEST - PROBABILIDADE E ESTATÍSTICA");
        probabilidadeEEstatistica.setYear(2023);
        probabilidadeEEstatistica.setSemester(1);
        probabilidadeEEstatistica.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        probabilidadeEEstatistica.setTeacher(marcosCirineuAguiarSiqueira);
        disciplinesService.save(probabilidadeEEstatistica);

        var programacaoLinear = new DisciplineModel();
        programacaoLinear.setName("PLIN - PROGRAMAÇÃO LINEAR");
        programacaoLinear.setYear(2023);
        programacaoLinear.setSemester(1);
        programacaoLinear.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        programacaoLinear.setTeacher(adrianoTavaresDeFreitas);
        disciplinesService.save(programacaoLinear);

        var programacaoOrientadaAObjeto = new DisciplineModel();
        programacaoOrientadaAObjeto.setName("POO - PROGRAMAÇÃO ORIENTADA A OBJETO");
        programacaoOrientadaAObjeto.setYear(2023);
        programacaoOrientadaAObjeto.setSemester(1);
        programacaoOrientadaAObjeto.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        programacaoOrientadaAObjeto.setTeacher(igorRafaelSilvaValente);
        disciplinesService.save(programacaoOrientadaAObjeto);

        var bancoDeDados = new DisciplineModel();
        bancoDeDados.setName("BD - BANCO DE DADOS");
        bancoDeDados.setYear(2023);
        bancoDeDados.setSemester(1);
        bancoDeDados.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        bancoDeDados.setTeacher(danielAlencarBarrosTavares);
        disciplinesService.save(bancoDeDados);

        var comunicacaoDeDados = new DisciplineModel();
        comunicacaoDeDados.setName("CDAD - COMUNICAÇÃO DE DADOS");
        comunicacaoDeDados.setYear(2023);
        comunicacaoDeDados.setSemester(1);
        comunicacaoDeDados.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        comunicacaoDeDados.setTeacher(jeanMarceloDaSilvaMaciel);
        disciplinesService.save(comunicacaoDeDados);

        var calculoNumerico = new DisciplineModel();
        calculoNumerico.setName("CNUM - CALCULO NUMÉRICO");
        calculoNumerico.setYear(2023);
        calculoNumerico.setSemester(1);
        calculoNumerico.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        disciplinesService.save(calculoNumerico);

        var estruturaDeDados = new DisciplineModel();
        estruturaDeDados.setName("ESTD - ESTRUTURA DE DADOS");
        estruturaDeDados.setYear(2023);
        estruturaDeDados.setSemester(1);
        estruturaDeDados.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        estruturaDeDados.setTeacher(inacioCordeiroAlves);
        disciplinesService.save(estruturaDeDados);

        var logicaParaComputacao = new DisciplineModel();
        logicaParaComputacao.setName("LCOMP - LÓGICA PARA COMPUTAÇÃO");
        logicaParaComputacao.setYear(2023);
        logicaParaComputacao.setSemester(1);
        logicaParaComputacao.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        logicaParaComputacao.setTeacher(thiagoAlvesRocha);
        disciplinesService.save(logicaParaComputacao);

        var analiseDeAlgoritmos = new DisciplineModel();
        analiseDeAlgoritmos.setName("ANALG - ANALISE DE ALGORITMOS");
        analiseDeAlgoritmos.setYear(2023);
        analiseDeAlgoritmos.setSemester(1);
        analiseDeAlgoritmos.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        analiseDeAlgoritmos.setTeacher(adrianoTavaresDeFreitas);
        disciplinesService.save(analiseDeAlgoritmos);

        var engenhariaDeSoftware = new DisciplineModel();
        engenhariaDeSoftware.setName("ENGS - ENGENHARIA DE SOFTWARE");
        engenhariaDeSoftware.setYear(2023);
        engenhariaDeSoftware.setSemester(1);
        engenhariaDeSoftware.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        engenhariaDeSoftware.setTeacher(sandyFerreiraDaCostaBezerra);
        disciplinesService.save(engenhariaDeSoftware);

        var grafos = new DisciplineModel();
        grafos.setName("GRAFOS - GRAFOS");
        grafos.setYear(2023);
        grafos.setSemester(1);
        grafos.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        grafos.setTeacher(darielsonAraujoDeSouza);
        disciplinesService.save(grafos);

        var introducaoAEletricidadeEEletronicaParaComputacao = new DisciplineModel();
        introducaoAEletricidadeEEletronicaParaComputacao.setName("IEEC - INTRODUÇÃO A ELETRICIDADE E ELETRÔNICA PARA COMPUTAÇÃO");
        introducaoAEletricidadeEEletronicaParaComputacao.setYear(2023);
        introducaoAEletricidadeEEletronicaParaComputacao.setSemester(1);
        introducaoAEletricidadeEEletronicaParaComputacao.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        introducaoAEletricidadeEEletronicaParaComputacao.setTeacher(elderDosSantosTeixeira);
        disciplinesService.save(introducaoAEletricidadeEEletronicaParaComputacao);

        var sistemasOperacionais = new DisciplineModel();
        sistemasOperacionais.setName("SO - SISTEMAS OPERACIONAIS");
        sistemasOperacionais.setYear(2023);
        sistemasOperacionais.setSemester(1);
        sistemasOperacionais.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        sistemasOperacionais.setTeacher(danielSilvaFerreira);
        disciplinesService.save(sistemasOperacionais);
    }
}
