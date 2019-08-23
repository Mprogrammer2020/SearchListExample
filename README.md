<p align="center"><img src="https://www.netsetsoftware.com/images2/logonetset.png"></p>
<h1 align="center">Android Search List Example using MVP Structure</h1>

## About Project
<b>IDE Used</b> : Android Studio<br>
<b>IDE Version</b>  : 3.5<br>
<b>Language</b> : Kotlin<br>
<b>Project Structure</b> : MVP(Model View Presenter)<br>
<b>Min Api Level</b> :19<br>
<b>Max Api Level</b> :29<br>

This project contain simple example of search using MVP structure. For networking : Retrofit and Rx-java are used.<br>

Model–view–presenter (MVP) is a derivation of the model–view–controller (MVC) architectural pattern which mostly used for building user interfaces. In MVP, the presenter assumes the functionality of the “middle-man”. In MVP, all presentation logic is pushed to the presenter. MVP advocates separating business and persistence logic out of the Activity and Fragment.

<h2><a id="user-content-dependencies" class="anchor" aria-hidden="true" href="#dependencies"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>Dependencies</h2>

<ul>
<li><a href="https://square.github.io/retrofit">Retrofit</a> - for networking</li>
<li><a href="https://github.com/ReactiveX/RxJava">Rx-Java</a> - for multithreading</li>
<li><a href="https://github.com/JetBrains/kotlin">Kotlin</a> - Language used</li>
<li><a href="https://developer.android.com/jetpack/androidx">AndroidX</a> - Support Library</li>
</ul>


<h2><a id="user-content-folders" class="anchor" aria-hidden="true" href="#folders"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>Folders</h2>
<ul>
<li><code>app</code> - Contains all the Eloquent models</li>
<li><code>base</code> - Contains base classes which contains common methods used in every class </li>
<li><code>presenter</code> -Presenter contains classes which are used to generate Views and bind Objects to them on demand. It is closely related to the concept of an RecyclerView.Adapter, but is not position-based. The leanback framework implements the adapter concept using ObjectAdapter which refers to a Presenter (or PresenterSelector) instance. </li>
</ul>


#### The app has following packages:
1. **api**: It contains all the Model and networking Api's.
2. **ui**: View classes along with their corresponding Presenters.
3. **utils**: Utility classes.




