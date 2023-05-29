package com.josealmir.gymmanagementsystem.service.implementations;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.josealmir.gymmanagementsystem.model.workoutplan.DailyWorkout;
import com.josealmir.gymmanagementsystem.model.workoutplan.Exercise;
import com.josealmir.gymmanagementsystem.repositories.DailyWorkoutRepository;
import com.josealmir.gymmanagementsystem.requests.DailyWorkoutRequest;
import com.josealmir.gymmanagementsystem.service.interfaces.DailyWorkoutService;

@Service
public class DailyWorkoutImpl implements DailyWorkoutService{
    @Autowired
    private DailyWorkoutRepository dailyWorkoutRepository;

    @Override
    public DailyWorkout createDailyWorkout(String dayOfWeek, List<Exercise> exercises) {
        DailyWorkout dailyWorkout = dailyWorkoutRepository.insert(new DailyWorkout(dayOfWeek, exercises));
        return dailyWorkout;
    }
    @Override
    public List<DailyWorkout> allDailyWorkouts() {
        return dailyWorkoutRepository.findAll();
    }
    @Override
    public Optional<DailyWorkout> dailyWorkoutById(String id) {
        return dailyWorkoutRepository.findDailyWorkoutById(id);
    }
    @Override
    public DailyWorkout updateDailyWorkout(String id, DailyWorkoutRequest dailyWorkoutRequest) {
        Optional<DailyWorkout> optionalDailyWorkout = dailyWorkoutRepository.findDailyWorkoutById(id);
        if(optionalDailyWorkout.isPresent()) {
            DailyWorkout dailyWorkout = optionalDailyWorkout.get();
            dailyWorkout.setDayOfWeek(dailyWorkoutRequest.getDayOfWeek());
            dailyWorkout.setExercises(dailyWorkoutRequest.getExercises());
            return dailyWorkoutRepository.save(dailyWorkout);
        } else {
            throw new NoSuchElementException();
        }
    }
    @Override
    public void deleteDailyWorkout(String id) {
        Optional<DailyWorkout> dailyWorkout = dailyWorkoutRepository.findDailyWorkoutById(id);
        if(dailyWorkout.isPresent()) {
            dailyWorkoutRepository.delete(dailyWorkout.get());
        } else {
            throw new NoSuchElementException();
        }
    }
}
