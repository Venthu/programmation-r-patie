package TP4;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


/**
 * Creates workers to run the Monte Carlo simulation
 * and aggregates the results.
 */
class Master {
  public void doRun(int totalCount, int numWorkers) throws InterruptedException, ExecutionException 
  {
    // Create a collection of tasks
    List<Callable<Long>> tasks = new ArrayList<Callable<Long>>();
    for (int i = 0; i < numWorkers; ++i) 
    {
      tasks.add(new Worker(totalCount));
    }
    
    // Run them and receive a collection of Futures
    ExecutorService exec = Executors.newFixedThreadPool(numWorkers);
    List<Future<Long>> results = exec.invokeAll(tasks);
    long total = 0;
    
    // Assemble the results.
    for (Future<Long> f : results)
    {
      // Call to get() is an implicit barrier.  This will block
      // until result from corresponding worker is ready.
      total += f.get();
    }
    double pi = 4.0 * total / totalCount / numWorkers;
    double time = 4.0 * total;
    exec.shutdown();
    System.out.println("n_loc : "+totalCount+ ", P : "+numWorkers);
  }
}



