package com.michaldrabik.storage.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.michaldrabik.storage.database.dao.*
import com.michaldrabik.storage.database.model.*

private const val DATABASE_VERSION = 1

@Database(
  version = DATABASE_VERSION,
  entities = [
    Show::class,
    DiscoverShow::class,
    FollowedShow::class,
    Image::class,
    User::class,
    Season::class,
    Episode::class,
    RecentSearch::class]
)
abstract class AppDatabase : RoomDatabase() {

  abstract fun showsDao(): ShowsDao

  abstract fun discoverShowsDao(): DiscoverShowsDao

  abstract fun followedShowsDao(): FollowedShowsDao

  abstract fun imagesDao(): ImagesDao

  abstract fun userDao(): UserDao

  abstract fun recentSearchDao(): RecentSearchDao

  abstract fun episodesDao(): EpisodesDao

  abstract fun seasonsDao(): SeasonsDao
}