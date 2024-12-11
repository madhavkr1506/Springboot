package winter.springboot.id004.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.stereotype.Service;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.util.CoreMap;
import winter.springboot.id004.response.sentence_response;
@Service
public class sentence_analysis {

    
    private ArrayList<String> positive_sentence = new ArrayList<>();
    private ArrayList<String> negative_sentence = new ArrayList<>();
    private ArrayList<String> neutral_sentence = new ArrayList<>();
    public void analyzesentence(sentence_response sentences){

        ArrayList<String> sentence_list = getStrings(sentences);

        Properties properties = new Properties();
        properties.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner,parse,sentiment");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(properties);

        for(int i=0;i<sentence_list.size();i++){
            Annotation annotation = new Annotation(sentence_list.get(i));
            pipeline.annotate(annotation);

            List<CoreMap> core_sentences = annotation.get(CoreAnnotations.SentencesAnnotation.class);

            for(CoreMap core_sentence : core_sentences){
                String sentiment = core_sentence.get(SentimentCoreAnnotations.SentimentClass.class);
                String string = core_sentence.toString();
                System.out.println("Sentence : " + string + " || Sentiment: " + sentiment);
                switch(sentiment.toLowerCase()){
                    case  "positive" :
                    positive_sentence.add(string);
                    break;
                    case "negative" :
                    negative_sentence.add(string);
                    break;
                    default : 
                    neutral_sentence.add(string);
                }
            }
        }
    }

    public ArrayList<String> getPositiveSentences() {
        return positive_sentence;
    }

    public ArrayList<String> getNegativeSentences() {
        return negative_sentence;
    }

    public ArrayList<String> getNeutralSentences() {
        return neutral_sentence;
    }
    private static ArrayList<String> getStrings(sentence_response sentences) {
        String identity = sentences.getIdentity();
        String life = sentences.getLife();
        String qualities = sentences.getQualities();
        String memories = sentences.getMemories();
        String sharing = sentences.getSharing();
        String time = sentences.getTime();
        String behavior = sentences.getBehavior();
        String relationship = sentences.getRelationship();
        String decision = sentences.getDecisions();
        String change = sentences.getChange();

        ArrayList<String> sentence_list = new ArrayList<>();
        sentence_list.add(identity);
        sentence_list.add(life);
        sentence_list.add(qualities);
        sentence_list.add(memories);
        sentence_list.add(sharing);
        sentence_list.add(time);
        sentence_list.add(behavior);
        sentence_list.add(relationship);
        sentence_list.add(decision);
        sentence_list.add(change);
        return sentence_list;
    }
}
