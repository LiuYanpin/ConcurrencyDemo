import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureAskDemo {
    public static class AskThread implements Runnable {
        CompletableFuture<Integer> re = null;

        public AskThread(CompletableFuture<Integer> re) {
            this.re = re;
        }

        @Override
        public void run() {
            int myRe = 0;
            try {
                myRe = re.get() * re.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println(myRe);
        }
    }

    public static Integer calc(Integer para) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return para * para;
    }

    public static Integer calcByZero(Integer para) {
        return para / 0;
    }

    public static Integer calcByTwo(Integer para) {
        return para / 2;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        /*final CompletableFuture<Integer> future = new CompletableFuture<>();
        new Thread(new AskThread(future)).start();
        Thread.sleep(1000);
        future.complete(60);*/
        /*final CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> calc(50))
                .thenApply(i -> Integer.toString(i))
                .thenApply(str -> "\"" + str + "\"").thenAccept(System.out::println);
        future.get();*/
        /*CompletableFuture<Void> fu = CompletableFuture.supplyAsync(() -> calcByZero(50))
                .exceptionally(ex -> {
                    System.out.println(ex.toString());
                    return 0;
                })
                .thenApply(i -> Integer.toString(i))
                .thenApply(str -> "\"" + str + "\"")
                .thenAccept(System.out::println);
        fu.get();*/
        /*CompletableFuture<Void> fu = CompletableFuture.supplyAsync(() -> calcByTwo(50))
                .thenCompose(i -> CompletableFuture.supplyAsync(() -> calcByTwo(i)))
                .thenApply(str -> "\"" + str + "\"")
                .thenAccept(System.out::println);
        fu.get();*/
        CompletableFuture<Integer> intFuture = CompletableFuture.supplyAsync(() -> calcByTwo(50));
        CompletableFuture<Integer> intFuture2 = CompletableFuture.supplyAsync(() -> calcByTwo(25));
        CompletableFuture<Void> future = intFuture.thenCombine(intFuture2, (i, j) -> (i + j))
                .thenApply(str -> "\"" + str + "\"")
                .thenAccept(System.out::println);
        future.get();
    }
}
