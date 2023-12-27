package com.example.spring5webapp.bootstrap;

import com.example.spring5webapp.models.Speaker;
import com.example.spring5webapp.models.Talk;
import com.example.spring5webapp.repositories.SpeakerRepository;
import com.example.spring5webapp.repositories.TalkRepository;
import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class BootStrapData implements CommandLineRunner {

    private final SpeakerRepository speakerRepository;
    private final TalkRepository talkRepository;

    public BootStrapData(SpeakerRepository speakerRepository, TalkRepository talkRepository) {
        this.speakerRepository = speakerRepository;
        this.talkRepository = talkRepository;
    }

    @Override
    public void run(String... args) {
        Random random = new Random();
        List<Speaker> savedSpeakers = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Speaker speaker = createRandomSpeaker();
            try {
                savedSpeakers.add(speakerRepository.save(speaker));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 100; i++) {
            Speaker randomSpeaker = savedSpeakers.get(random.nextInt(savedSpeakers.size()));
            Talk talk = createRandomTalk();
            talk.setSpeakers(randomSpeaker);
            randomSpeaker.getTalks().add(talk);
            try {
                talkRepository.save(talk);
                speakerRepository.save(randomSpeaker);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    private Speaker createRandomSpeaker() {
        Speaker speaker = new Speaker();
        speaker.setFirstName(Faker.instance().name().firstName());
        speaker.setLastName(Faker.instance().name().lastName());
        Set<Talk> talks = createRandomTalks(100);
        speaker.setTalks(talks);
        return speaker;
    }

    private Set<Talk> createRandomTalks(int numberOfTalks) {
        Set<Talk> talks = new HashSet<>();
        // Generate random talk data and add them to the set
        for (int i = 0; i < numberOfTalks; i++) {
            Talk talk = createRandomTalk();
            talks.add(talk);
        }
        return talks;
    }

    private Talk createRandomTalk() {
        Talk talks = new Talk();
        talks.setTalkNumber(String.valueOf(Faker.instance().number().digits(3)));
        talks.setTalkName(Faker.instance().name().name());
        return talks;
    }
}
