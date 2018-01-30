package ConcurrentCollections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ThreadPoolExecutor;

public class EmployeeWithConcurrentCache {
    private ConcurrentHashMap<Integer,Employee> cache;
    private ThreadPoolExecutor executor;
    private String[] departments;

    public EmployeeWithConcurrentCache(ThreadPoolExecutor executor, String[] departments){
        this.cache= new ConcurrentHashMap<>();
        this.executor=executor;
        this.departments=departments;
    }

    public Employee getEmployee(Integer id){
        return cache.computeIfAbsent(id,this::computeEmployee);
    }

    public int size(){
        return cache.size();
    }

    private Employee computeEmployee(Integer integer) {
        try {
            return executor.submit(() ->{
                int i = ThreadLocalRandom.current().nextInt(departments.length);
                Thread.sleep(10);
                return new Employee(integer, departments[i],false);
            }).get();
        }catch (Exception e){
            System.out.println("Failed to compute employee "+ integer);
            return null;
        }
    }
}
