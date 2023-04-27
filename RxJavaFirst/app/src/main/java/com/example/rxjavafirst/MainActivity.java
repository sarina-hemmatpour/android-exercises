package com.example.rxjavafirst;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;

public class MainActivity extends AppCompatActivity {

    Disposable disposable;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        Observable.just("Tiger" , "bird","lion","Bear")
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable=d;
                        Log.i(TAG, "onSubscribe: ");
                    }

                    @Override
                    public void onNext(String s) {
                        Log.i(TAG, "onNext: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, "onError: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.i(TAG, "onComplete: ");
                    }
                });


        //If we list all the natural numbers below 10 that are multiples of 3 or 5,
        // we get 3, 5, 6 and 9. The sum of these multiples is 23.
        // Find the sum of all the multiples of 3 or 5 below 1000.
        Observable.range(1,999)
                .filter(integer -> integer%3==0 || integer%5==0)
                .reduce((x,y)-> x+y)
                .subscribe(new MaybeObserver<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onSuccess(Integer integer) {
                        Log.i(TAG, "onSuccess: "+ integer); //onSuccess: 233168
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        Log.i(TAG, "onComplete: ");
                    }
                });

        //How could you create an Observable that emits the Fibonacci sequence?

        fibObservable().subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {
                Log.i(TAG, "["+integer+"] , ");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "onError: ");
            }

            @Override
            public void onComplete() {

            }
        });

         */


        /*
        //map
        Observable.just(1 , 2, 3,4 , 5 ,6 ,7)
                .map(n->"Number= "+n+", ")
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        Log.i(TAG, s);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

         */



        /*
        //flatmap
        //tartibe zazmani hefz nemishe
        //ye observable e jadid ijad mikone
        Observable.just(1 , 2, 3,4 , 5 ,6 ,7)
                .flatMap(n-> Observable.just(n , n*10 , n*100).delay(2,TimeUnit.SECONDS))
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer integer) {

                        Log.i(TAG, "onNext: "+integer);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                        Log.i(TAG, "onComplete: ");
                    }
                });

         */

        /*
        //concatMap
        //mesle flatMap vali ba tartibe zamani
        Observable.just(1 , 2, 3,4 , 5 ,6 ,7)
                .concatMap(n-> Observable.just(n , n*10 , n*100).delay(2,TimeUnit.SECONDS))
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.i(TAG, "onNext: "+integer);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

         */


        /*
        //switchMap
        //akharin observable ro negah midare
        Observable.just(1 , 2, 3,4 , 5 ,6 ,7)
                .switchMap(n-> Observable.just(n , n*10 , n*100).delay(2,TimeUnit.SECONDS))
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.i(TAG, "onNext: "+integer);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


         */



        /*
        //interval
        //mitune jaygozine timer e android beshe
        // moshkelat: ro ye thread e digast - memory leak
        Observable.interval(1 , 1 , TimeUnit.SECONDS)
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable=d;
                    }

                    @Override
                    public void onNext(Long aLong) {

                        Log.i(TAG, "onNext: " + aLong.toString());

                        //canceling timer
                        if (aLong.toString().equals("10"))
                            disposable.dispose();

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

         */

        /*
        //timer
        //bade ye meghdar zaman yek item ra emit mikonad
        Observable.timer(1 , TimeUnit.SECONDS)
                .doFinally(()->{
                    Log.i(TAG, "The End.");
                })
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Long aLong) {
                        Log.i(TAG, "onNext: " + aLong.toString());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


         */

        // /////////////////////////////////////////////////////////////////////////////////////////

        //Subjects


        //publish subject
        PublishSubject<Integer> subject=PublishSubject.create();

        subject.onNext(1);
        subject.onNext(2);
        subject.onNext(3);

        //subject.subscribe((number) -> Log.i(TAG, "onNext: " + number)); // 4 5 6
        subject.subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                disposable=d;
            }

            @Override
            public void onNext(Integer integer) {
                Log.i(TAG, "onNext: " + integer);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.i(TAG, "onComplete: publish");
                disposable.dispose();
            }
        }); // 4 5 6

        subject.onNext(4);
        subject.onNext(5);
        subject.onNext(6);


        subject.onComplete();

        //behavior
        BehaviorSubject<Integer> subject1=BehaviorSubject.create();

        subject1.onNext(1);
        subject1.onNext(2);
        subject1.onNext(3);

        subject1.subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                disposable=d;
            }

            @Override
            public void onNext(Integer integer) {
                Log.i(TAG, "onNext: " + integer);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.i(TAG, "onComplete: behavior");
                disposable.dispose();
            }
        }); // 3 4 5 6

        subject1.onNext(4);
        subject1.onNext(5);
        subject1.onNext(6);

        subject1.onComplete();
        //replay

        ReplaySubject<Integer> subject2=ReplaySubject.create();

        subject2.onNext(1);
        subject2.onNext(2);
        subject2.onNext(3);

        subject2.subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                disposable=d;
            }

            @Override
            public void onNext(Integer integer) {
                Log.i(TAG, "onNext: " + integer);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.i(TAG, "onComplete: replay");
                disposable.dispose();
            }
        }); // 1 2 3 4 5 6

        subject2.onNext(4);
        subject2.onNext(5);
        subject2.onNext(6);

        subject2.onComplete();


    }

    public Observable<Integer> fibObservable(){
        return Observable.create((emitter -> {
            int f0=0 , f1=1, fNext=0;
            try {
                while (!emitter.isDisposed()){
                    emitter.onNext(fNext);
                    fNext=f0+f1;
                    f0=f1;
                    f1=fNext;
                }
            }catch (Exception e){
                if (!emitter.isDisposed()){
                    emitter.onError(e);
                }
            }
        }));
    }
}