package ru.ladgertha.asteroidradar.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import ru.ladgertha.asteroidradar.repository.RepositoryProvider


class GetNewDataWorker(
    private val context: Context,
    parameters: WorkerParameters
) : CoroutineWorker(context, parameters) {

    override suspend fun doWork(): Result {
        val asteroidRepository = RepositoryProvider().getAsteroidRepository(context)
        val imageRepository = RepositoryProvider().getImageOfTheDayRepository(context)

        return withContext(Dispatchers.IO) {
            try {
                asteroidRepository.updateAsteroidList()
                imageRepository.updateImage()
                Result.success()
            } catch (exception: HttpException) {
                Result.retry()
            }
        }
    }

    companion object {
        const val GET_NEW_DATA_WORKER_NAME = "GetNewDataWorker"
    }
}