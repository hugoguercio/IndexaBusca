/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstruturasTrie;

import indexa.busca.Documento;
import indexa.busca.PalavraUnicaTrie;
import indexa.busca.Par;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Qih
 */
public class Trie {
    /*
        Atributos
    */
    private NoTernario raiz;
    private ArrayList<Documento> documentos;
    
    
 public String[] PTumaChave={"9744", "chialamberto", "ugandenses", "semsales", "2027", "cog", "krosigk", "tib", "gassol", "bizerta", "1925316607", "anisoptera", "mlxv", "ucokwe", "00575997", "featurettes", "17019", "yehudhah", "157754este", "1970atuou", "powerheavyspeed", "canny", "mundomas", "mindbenders", "2089", "heikki", "259654este", "catalografica", "ambarikorano", "papamichael", "qbe", "eragrostideaeas", "anosemanuela", "kleinsendelbach", "psicose", "73ta", "bardoja", "cetoenolica", "021065357", "2531667", "540129este", "mirambel", "viloescriado", "liquidificador", "1216", "sentimentos", "cursa", "bizness", "01691316", "nettesheim", "liev", "mistislau", "masefield", "linpingupuapa", "16203", "zapotitlan", "benhinom", "malacanthidae", "comite", "kaliningrad", "extraccao", "borbensis", "621857", "acclaimem", "boweslyon", "sapienza", "lonas", "alergeno", "piassaba", "2003mais", "logm", "19791989", "picart", "anosharryatkinson", "volin", "abatroz", "oinos", "weidner", "egipciatutmes", "rabona", "1726", "gstreamer", "anosnancynoblitt", "krypto", "golf", "auntie", "anosalkon", "letona", "palatino", "augellocook", "abdica", "sophocles", "retribution", "pastado", "abdominosquise", "aniston", "frc", "01119039", "imida", "pulmonarsao"};
    public String[] PTduasChaves={"akahori internacao", "basc trebbiano", "noroestekhalabat cultivadas", "nortenordesteem libertines", "alauda areaold", "18938483 cappa", "aeronavesestes eghersec", "8604699 climacteridaeeste", "00886775 velospiri", "extensaoao comprimidase", "retidao palminerveas", "going bathybela", "prata envoltos", "morona 1247", "11681190 proclamar", "frimario foixa", "crosby sudestenoroeste", "itaunasrio amsterdam", "polegaro kramers", "sirmia 00132355", "tibetobirmanesas suicas", "205124 evrou", "filmequadrophenia 19201743", "toxicidade argumentos", "concessionado holandesacarece", "provocados bignoniaceae", "120kmh euryclides", "nihonjin tschudii", "qualificarao gundalian", "neuilly katet", "brancoconsiderado filhotes", "thebaldus aplicandoo", "lst685 pacilo", "dunites 00815209", "algawwiya tabak", "separe manipula", "llanover empanados", "serina balnearcomposta", "prairial eursinge", "bacabinha exsecta", "stagnatilis balasko", "fetoredondoa alemaoera", "trithuria gowans", "iringaprom geograficasig", "paulofundado semsales", "costaceae resultem", "1977amory looking4larry", "ideintegrated timizzolu", "temperaturasua francesacaiena", "triagem telecopia", "57963 charqueada", "escamada espanholpossui", "aemilia suecooriginario", "ablakon v3", "plicocomo raimund", "profissionalmente registrador", "2141716754 paralelamente", "mcclxxxix 19601977", "traducaona qirshan", "athi transponders", "traseiravendida 2026828", "realizando comitancillo", "suprime lacolitos", "precisaoe 5079", "reimportalo anos6049", "tesouroo 29892", "subtropicais angelofausto", "mobilis fw12c", "storia nuon", "distimico votaram", "rybnicki attem", "espaciaisa recomendam", "tequilla 8804", "cutler gardina", "palavraestudo paterae", "chone columbiana", "psicanalitico wangenbruttisellen", "2010nao fifaos", "nurague feicoes", "1842atualmente synoikismos", "eeden goyeneche", "01054954 mahieu", "sawmills habil", "01596655 johannmeyer", "posindustrial kamalich", "rumor abraaoassim", "sira balmoral", "cojasca tgf", "batesi petropavlovskkamchatskiy", "criollos rdco", "vikingeskibsmuseet moldavios", "00805074 astral", "pomaderris anosshinonaga", "aeromodelo cqwpx", "conjuntivos mefistofeles", "selandiana attelabidae", "drenados hysteria", "millar pousadasem", "imunossupressor 15389", "56783 epidemica", };    //public String[] PTumaChave = {"178978487","publica","corrado","ultraviolet","26151","asteroidesfoi","cestinho","hyelion","vincas","indirectos","joop","musharrif","184773091","334497este","tracos","jaltziotys","85000","bashevis","solfa","devsda","2707899","alouatta","1889matsuyama","avioesiniciando","ct","cidadecondado","1840","domingosan","califato","aremark","kirchworbis","fontenoyenpuisaye","gcse","makokou","1569947","gazetto","10055","thoreau","calyptrocalyx","consegiu","eliminados","bytnicade","adarve","pamiers","petrovicnjegos","21729999","esgana","referenciashe","jogevalaanemaa","nicseni","panamaa","monomania","1847953este","parboiled","mozaffar","escoceso","santegidio","smittendownes","hoplobatrachus","brezovka","carsticas","humorista","22230698","vantajosos","torrelaguna","xianyong","anedotas","possibilidadeso","desconsiderando","madibulas","alviss","competem","dimorphandra","truncatellina","buxo","p38","interpretatio","hirasea","17289","anneke","unidosnos","1817862598","1844politicamente","dematerialisation","2905","lesivas","11146","acheson","distintosa","anosseydler","convivemseu","youngbae","23357641","muhlenbach","iberezao","megadethcomecou","caldeiras","mizrahim","allersberg","sandoval"};        
    public String[] PTtresChaves ={"carvalho brazo destrutivas", "publica 21694 prunetto", "corrado churcampa 61556", "ultraviolet disser nyquist", "26151 chantillon koninck", "asteroidesfoi menace coimperadores", "cestinho warwick benedict", "hyelion anosnishimurajun hyemalis", "vincas henyey dipsacaceae", "indirectos amadureciam latinacomecou", "joop mitosecarece anosmarcelriesz", "musharrif orleanesia stryn", "184773091 vansbro talimuhe", "334497este desposada tobiszowski", "tracos hipocolia 23050844", "jaltziotys condimentado exalacao", "85000 tamines zwedena", "bashevis tchecocomecou soroseris", "solfa trecento olacaceae", "devsda atacando yaquimel", "2707899 longicornis vilayet", "alouatta regiaometropolitana chuleio", "1889matsuyama trabiju anselaraye", "avioesiniciando hamersheim coprogramadores", "ct corticobasal ikf", "cidadecondado couto browninglevesque", "objeto kenai presencial", "domingosan 485852 anostammytam", "califato resultadosrecorde siciliennes", "aremark etologiakonrad mohun", "kirchworbis bestial muidinga", "fontenoyenpuisaye mesofilo lepanto", "gcse esteticas polemico", "makokou megalopole mt9", "1569947 ifb baila", "gazetto ravi taitianas", "10055 torregalindo ardhi", "thoreau godflesh odisseia", "calyptrocalyx tortuguero 1091482este", "consegiu superregnum 2233", "eliminados musashisan wwo", "bytnicade voltaire algiers", "adarve personalizada rufina", "pamiers racisce berganza", "petrovicnjegos cedo franscisco", "21729999 capital curcialeiro", "esgana mundial gymnomuraena", "1546 micromeros dourofundada", "jogevalaanemaa sericicultura chiusano", "teste ch3coochch2 compatibilidadelancado", "panamaa wulff angiospermaseste", "monomania investigo acacu", "1847953este 155092este dover", "parboiled 2906s 8494", "mozaffar robberts 48008", "escoceso 1961a simant", "santegidio lhe vingativa", "smittendownes ferindose koleos", "hoplobatrachus datinfo doberman", "brezovka consomem sanctorius", "carsticas mendozaera joaodebarro", "humorista 908000 albernaz", "22230698 70575 ogle2005blg390l", "vantajosos objecoes naottopera", "torrelaguna kingstonian neutras", "xianyong 9402 fideoja", "anedotas 1402667 polanski", "possibilidadeso nomee ryssota", "desconsiderando 6630 bakula", "madibulas actuam 1995amorgos", "alviss aideticos 684407este", "competem 3059750 iniciado", "dimorphandra educativa skodje", "truncatellina favoreciam vrchovnice", "buxo juizados torrao", "p38 beneixida carnwath", "interpretatio posen intencionalidadenuma", "hirasea 61702 pousada", "17289 yp tears", "anneke 14252 velorumlambda", "unidosnos herdaria canhoneiros", "1817862598 hinesville jerzmanowiceprzeginia", "1844politicamente sabalgarh catalaodesde", "dematerialisation sveti isler", "2905 conferindo anosmutchler", "lesivas corintiano 14801535", "11146 ogorman bales", "acheson vanir tethys", "distintosa 953907este deuses", "anosseydler ardara fist", "convivemseu 2uma ninnemann", "youngbae 4152 habkmconstituiu", "23357641 robertobacci brasileiramay", "muhlenbach bilosca neodimioferroboro", "iberezao arquiduquesa serrieres", "megadethcomecou madrugadade jaguelons", "caldeiras relais crypturellus", "mizrahim syndyophyllum pedion", "allersberg kiyomori osella", "sandoval estrategopulo volumes"};    
    public String[] ENumaChaves={"correctitude","sota","d5581","spongeminkowskibouligand","venganza","northcote","calvaria","commissioners","pavilionthe","exhibits","surmatants","figurea","kurau","volvosuggan","nowodworski","killfile","estonianbased","yadollah","censusmorenci","chicagonapervillemichigan","14619","ripton","7503","424948","yasubei","tattoos","strengths","speculativearticles","systemit","3284","darat","natchitochesthe","satyra","montsoreau","516","scinto","tagtgrenmusically","osri","wuneng","gucs","elevating","nightfall","resurface","villageryken","hemimetabolism","orol","aggro","rncl2","bratislava","taxonomy","namshubas","nicd","brethd","warhead","ejectors","kumblnd","ppb","pelecanidae","sloughed","pelendur","structurea","rushes","conesus","hovercraftclassic","noichride","spitfire","clashfern","nemdi","ippr","andimeshk","albumto","150599","c16261687","daibiao","kongsang","excidio","akashi","joll","cky","sassisuperga","doublespurred","cmo","mdccclx","enrogel","lytic","farsh","lumleys","censusgrayling","prmado","reiterates","pixiebobs","nan2","metohija","nederlandsche","nyaunglebin","crossconnections","exocytosis","flos","carbondale","vinceia"};
    public String[] ENduasChaves={"borderashbydelazouch provegetarian", "kennedys westernthemed", "exaggerates 052124160x", "browserbased knyazhna", "country1000000000000000000000000000000000 takeoff", "12684 aymaran", "leucippushilaeira allseated", "exportoriented 308328", "sciencehe tremalose", "protrs circuitsa", "backstreet vandevelde", "auchun energia", "premrna centuryhe", "beyrouth spivak", "alaksandu cucurbitales", "antitax matka", "strabos brtoln", "kalakunlun nonprimordial", "gunder kodaly", "channeled joseba", "ialpug montefiori", "endmember 8482", "belser aged", "hoensbroek rapiito", "arzalluz mckenney", "regret horelick", "jugoslovenski etchegaray", "pirna awaara", "vladislav 3642", "18244 himit", "smily macrina", "langar cpe", "heppner plts", "ostm 10064", "turkwel 2686", "kwdr larnax", "tractricoid ndrisn", "chikita bedazzled", "technologyfounded djadokhta", "walhonding ldz", "santorum crystallizing", "0885 escueta", "stanlawe raimond", "democraat girgashite", "objectsit lofton", "tullia abkhazadyghe", "nrpldi venice", "meneted canonero", "refa hispanica", "qasas rsw", "methacrylate drowne", "trfn sastmola", "josep bahato", "eeliss kratum", "hliwd wunseradiel", "echinoids parutena", "systemsinner wingthe", "honoree extracranial", "animalslike volkswagens", "whore 31877", "dehumidifier eurydame", "ataullah kolback", "indexthe rddc", "tenno rayslead", "urhoy geologyexamples", "unexplored pocono", "kepo trionfi", "foppa bodinnick", "fibresone 19861993", "eighteenthcentury falwell", "rb80 wladyslaw", "nattfodd pobra", "celebified teleleisa", "ricoguam sakamaki", "12081 actuates", "mccarrell perkins", "microfilmer lekhko", "390724 legacy", "none bcl2", "wwrs ramdev", "crommelin budweiser", "associationcurrent medr", "divinity buzenshi", "bussey frater", "andreotti acetamide", "unhulled isa", "exaggerating terminations", "watertight myrdal", "uranuss nanoarchaeum", "giuseppina designtender", "lsd36 kelso", "2014kiel privative", "5852 allowable", "nearbyas unchanging", "recordstotal independentistgerard", "66135 synchrotronbased", "punthe 190000", "subobject gusha", "ligne branchless", "borat makarovs"};
    public String[] ENtresChaves={"yanthe 2010jordanow guskinother", "calkini oberfeldwebel akademos", "bartokmikrokosmos ofabout lincos", "alternatortoday meio 107624", "kamishihoroshintoku kemper accoramboni", "rolesglam hwaeom spindleshaped", "rearfanged pitoni taspo", "17791869 negotiations 1882111212", "theoryin langen neurally", "42860 tpatchers horai", "pleiadeshis 32000 671", "trucksrush fairfax 79788", "codeglycine deaths panpeter", "sikorsky placetas wrightset", "chakras ini 8144", "nidelva ticks workerpeasant", "zorobabel pumi patsy", "karlskoga officeindira kabetogama", "romaniei honeymanscott anax", "18761882 hainan syklohpeez", "lancamento inuko 2001based", "heartedly ceremonialhe notarius", "esfnd demokratische 26this", "silanus wynda briers", "18531923 tmrc kahuku", "marcel monitors trashiyangtse", "podmore savinkov zipwell", "mishmash doublechecked mmtj", "storebltsforbindelsen verbose membershipthe", "microenterprise panj 9425", "bntu caife abrtau", "predominance increasing 1848present", "ethic 2001based forensics", "censusfederal estanciatorrance aptrgangr", "88721 tygarts mvah", "103299 centuryspending manzikert", "hokah puppets 1581", "tinrdlu cknds tocopherols", "hebhra korce nahrain", "hafeze zma millbury", "goods daub judaisms", "hefele wirehaired inhibitors", "aylesburyuntil 1811since kstemplateas", "britainat hitmen politicianwaddell", "aldaric cercidiphyllaceae ecountry", "dubo februarys 46225", "skfd amherst xingjian", "kondaveedu decaturaccording pressingsthe", "setshe bourdelle brewood", "abbreviationsacronyms engelenburg paulofernandopolis", "c3h6o3the rudolfs 19231926", "chainlets 48bit sa8", "oncfs 1856072323 scopolamine", "meton legitimize filibert", "clxx 014 matkustin", "pitting lamarckian rodgers", "felids bebelplatz tripometer", "wunda wirelessalthough monthin", "relationsson byzantinesassanid strossen", "functionalities belledonne survivalist", "porajmos georgesjean latinlanguage", "1914although unmk cmxciii", "adherence 18681933he arnis", "sunyesf opossum goldmanhe", "writerfor oels 525", "loi4 allotropism dyoof", "optometry lishanan espenson", "bc215 clothcovered girtin", "2321in fjr a73", "alkull 2083 loops", "lct50 spock burghoff", "rrvik 19751976 namndeman", "chinesethe tsim kerubini", "brighton knightswasps chingkuo", "78532 vltava 1222", "europehe 18451913 fritzs", "reradiation smolan rhayader", "2060for calotype welplaat", "matka ziwei laborda", "13424 aime wellon", "behave indiansthe shortcrust", "shishido subadditivity valckenaer", "03322 seochogu kharabat", "hypermnestra gearoid urhoy", "keres polynesianstyle itikaf", "maryknoll jeroboam malachias", "hudiksvalls 755 cryptocellus", "oberonseveral tshadrenocorticotropic 12478", "chinkoa chinoy broadsheets", "titicaca finnbhennach jevons", "expectednames musca vahieroa", "mooloolah woolstock aikane", "531579 soerabaia savimbi", "euless nagaru countygeorgetown", "viceversa c2h2 poojah", "directdraw loudspeakers opennap", "yarwell kundra programmingwwe", "crinoids yeste nkrumah", "bardi sarat emekci", "giantsize carota supermans"};
    
    /*
        Getters e Setters
    */
    public void insereDocumento(Documento d){
        if(this.documentos == null){
            this.documentos = new ArrayList<Documento>();
        }
        this.documentos.add(d);
    }        
    public Documento getIndex(int i){
        return this.documentos.get(i);
    }
    public ArrayList<Documento> getDocumentos() {
        return documentos;
    }
    
    public int getContagemPalavraUnicaDoDoc(int doc_id){
        for (int i=0; i<documentos.size();i++){
            if(doc_id== documentos.get(i).getDoc_id()){
                return documentos.get(i).getPalavrasDistintas();
            }
        }        
        
        return 0; 
   }
    
    
    /*
        Construtor
    */
    public Trie() {
        raiz = new NoTernario();
    }

    /*
        Métodos
    */
    
    /*
        Métodos de inserção
    */
    public void insere(String palavra) {
        if (palavra != null && !palavra.isEmpty()){
            //chama o insere passando a raiz
            insere(palavra, 0, raiz);
        }
    }

    private NoTernario insere(String palavra, int posicao, NoTernario no) {
        char ch = palavra.charAt(posicao);
        //Nó não existe
        if (no == null){
            no = new NoTernario(ch);
        }
        
        if (ch < no.letra){
            no.esquerda = insere(palavra, posicao, no.esquerda);
        }
        else if (ch > no.letra){
            no.direita = insere(palavra, posicao, no.direita);
        }
        else if (posicao < palavra.length() - 1){
            no.meio = insere(palavra, posicao + 1, no.meio);
        }
        else{
            no.folha = true;
        }
        return no;
    }
    
    public void insereComPar(String palavra, Par par) {
        if (palavra != null && !palavra.isEmpty()){
            //chama o insere passando a raiz
            insereComPar(palavra, 0, raiz, par);
        }
    }
    
    private NoTernario insereComPar(String palavra, int posicao, NoTernario no, Par par) {
        char ch = palavra.charAt(posicao);
        //Nó não existe
        if (no == null){
            no = new NoTernario(ch);
        }
        
        if (ch < no.letra){
            no.esquerda = insereComPar(palavra, posicao, no.esquerda, par);
        }
        else if (ch > no.letra){
            no.direita = insereComPar(palavra, posicao, no.direita, par);
        }
        else if (posicao < palavra.length() - 1){
            no.meio = insereComPar(palavra, posicao + 1, no.meio, par);
        }
        else{
            if(no.folha == false){
                no.inserePrimeiroPar(palavra, par);
            }
            
            no.folha = true;
            no.inserePar(palavra, par);
        }
        return no;
    }
    
    /*
        Método de contido
    */
    public boolean contido(String palavra) {
        //Palavra vazia ou null
        if (palavra == null || palavra.isEmpty()){
            return false;
        }
        
        return contido(palavra, 0, raiz);
    }

    private boolean contido(String word, int index, NoTernario node) {
        if (node == null){
            return false;
        }
        char ch = word.charAt(index);
        if (ch < node.letra){
            return contido(word, index, node.esquerda);
        }
        if (ch > node.letra){
            return contido(word, index, node.direita);
        }
        if (index < word.length() - 1){
            return contido(word, index + 1, node.meio);
        }
        return node.folha;
    }

    /*
        Método de busca
    */
    
    public NoTernario buscar(String palavra){
        //Palavra vazia ou null
        if (palavra == null || palavra.isEmpty()){
            return new NoTernario();
            
        }
        return buscar(palavra, 0, raiz);
        
        
    }

    private NoTernario buscar(String word, int index, NoTernario node)  {
        if (node == null){
            return raiz;
        }
        char ch = word.charAt(index);
        if (ch < node.letra){
            return buscar(word, index, node.esquerda);
        }
        if (ch > node.letra){
            return buscar(word, index, node.direita);
        }
        if (index < word.length() - 1){
            return buscar(word, index + 1, node.meio);
        }
        return node;
    }

    /*
        Calcula o Wij
    */
    public double calculaPeso(int count, int totalDocumentos, int totalDocumentosComPalavra){
        if(totalDocumentosComPalavra == 0){
            return 0;
        }
        double d= count * ((Math.log((double)totalDocumentos)/ Math.log(2))/ (double)totalDocumentosComPalavra);
        return d;
    }
    
    public ArrayList<Par> busca(String chave){
        ArrayList<Par> listaPares=null;
        if(this.contido(chave)==false){
            return listaPares;            
        }
        else{
            listaPares = this.buscar(chave).getListaDocumentosComPalavra().getPares();
            
            
        }

        if(this.contido(chave)){
            //System.out.println("Palavra não encontrada em nenhum documento!");
            return listaPares;
        }else{
            Par parAux;
            //PalavraUnica pTeste = null;
            PalavraUnicaTrie pTeste = null;
            pTeste = this.buscar(chave).getListaDocumentosComPalavra();
                    //Para cada par calcula o idf                     
                    listaPares = pTeste.getPares();
                    for (int j = 0; j < listaPares.size();j++) {
                    //esta calculando o mesmo idf para todos
                        parAux = pTeste.getPares().get(j);
                        parAux.setIdf(calculaPeso(listaPares.get(j).getCount(), this.getDocumentos().size(), listaPares.size()));
                    }
                    Collections.sort(listaPares);
                    pTeste.setPares(listaPares);
                 //   System.out.println("print de teste do doc_id da busca: "+listaPares.get(0).getDoc_id());

            return listaPares;
        }
    }  
    
    public ArrayList<Par> buscaMultiplas(String[] chave){        
        ArrayList<Par> listaParesUnificados = new ArrayList<Par>();
        ArrayList<Par> listaParAux =new ArrayList<Par>();
        ArrayList<Par> listaParUnificadoSemDuplicados =new ArrayList<Par>();
        double idfTotal=0;
        //Para cada palavra pega o TF
        for(int i =0;i<chave.length;i++){
            listaParAux = this.busca(chave[i]);
            //Adiciona todos os pares na lista unificada
            if(listaParAux!=null){
                for(int k=0; k<listaParAux.size();k++){
                    listaParesUnificados.add(listaParAux.get(k));
                }
            }
        }        
        
        Collections.sort(listaParesUnificados);
        if(listaParesUnificados.size()==0){
            return listaParesUnificados;
        }
        idfTotal=listaParesUnificados.get(0).getIdf();
        for(int l=1;l<listaParesUnificados.size();l++){
            if(listaParesUnificados.get(l-1).getDoc_id()==listaParesUnificados.get(l).getDoc_id()){
                idfTotal += listaParesUnificados.get(l).getIdf(); 
           }else{
                //insere na lista o par com valor de tfidf
                listaParUnificadoSemDuplicados.add(new Par(listaParesUnificados.get(l-1).getDoc_id(), ((1/this.getContagemPalavraUnicaDoDoc(listaParesUnificados.get(l-1).getDoc_id()))*idfTotal)));
            }
            
            //trata o ultimo elemento
            if((l+1)==listaParesUnificados.size() ){
                //é diferente
                if(listaParesUnificados.get(l-1).getDoc_id()!=listaParesUnificados.get(l).getDoc_id()){
                    listaParUnificadoSemDuplicados.add(new Par(listaParesUnificados.get(l).getDoc_id(), ((1/this.getContagemPalavraUnicaDoDoc(listaParesUnificados.get(l).getDoc_id()))*listaParesUnificados.get(l).getIdf())));
                }else{
                    listaParUnificadoSemDuplicados.add(new Par(listaParesUnificados.get(l-1).getDoc_id(), ((1/this.getContagemPalavraUnicaDoDoc(listaParesUnificados.get(l-1).getDoc_id()))*idfTotal)));
                }
                
            }
        }
        
        Collections.sort(listaParUnificadoSemDuplicados);
        return listaParUnificadoSemDuplicados;
    }
    
    public void fazBuscas(String[] chaves, String[] chaves2, String[] chaves3){
        long startTime1 = System.nanoTime();
        Documento d = new Documento();
        String[] chavesMultiplas;
        for(int i=0;i<100;i++){
            this.busca(chaves[i]);
                        
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime1); 
        double seconds = (double)duration /  1000000.0;
        System.out.println("\n100 buscas aleatórias (1 palavra): "+seconds+" millisegundos");
        
        //2 chaves
        long startTime2 = System.nanoTime();
        for(int i=0;i<100;i++){
            chavesMultiplas = d.identificaPalavras(chaves2[i]);
            this.buscaMultiplas(chavesMultiplas);
                        
        }
        long endTime2 = System.nanoTime();
        long duration2 = (endTime2 - startTime2); 
        double seconds2= (double)duration2 /  1000000.0;
        System.out.println("\n100 buscas aleatórias (2 palavra): "+seconds2+" millisegundos");
        
        //3 chaves
        long startTime3 = System.nanoTime();
        for(int i=0;i<100;i++){
            chavesMultiplas = d.identificaPalavras(chaves3[i]);
            this.buscaMultiplas(chavesMultiplas);
                        
        }
        long endTime3 = System.nanoTime();
        long duration3 = (endTime3 - startTime3); 
        double seconds3= (double)duration3 / 1000000.0;
        System.out.println("\n100 buscas aleatórias (3 palavra): "+seconds3+" millisegundos");
        
    }
    
    
    /*
        Busca de prefixos
    */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.isEmpty()){
            return false;
        }
        return startsWith(prefix, 0, raiz);
    }

    private boolean startsWith(String prefix, int index, NoTernario node) {
        if (node == null){
            return false;
        }
        char ch = prefix.charAt(index);
        if (ch < node.letra){
            return startsWith(prefix, index, node.esquerda);
        }
        if (ch > node.letra){
            return startsWith(prefix, index, node.direita);
        }
        if (index == prefix.length() - 1){
            return true;
        }
        return startsWith(prefix, index + 1, node.meio);
    }
}

