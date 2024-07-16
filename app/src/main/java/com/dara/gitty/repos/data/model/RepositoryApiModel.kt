package com.dara.gitty.repos.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RepositoryApiModel(
    val id: Int,
    @SerialName("node_id") val nodeId: String,
    val name: String,
    @SerialName("full_name") val fullName: String,
    val owner: OwnerApiModel,
    @SerialName("private") val isPrivate: Boolean,
    @SerialName("html_url") val htmlUrl: String,
    val description: String?,
    val fork: Boolean,
    val url: String,
    @SerialName("created_at") val createdAt: String,
    @SerialName("updated_at") val updatedAt: String,
    @SerialName("pushed_at") val pushedAt: String,
    val homepage: String?,
    val size: Int,
    @SerialName("stargazers_count") val stargazersCount: Int,
    @SerialName("watchers_count") val watchersCount: Int,
    val language: String?,
    @SerialName("forks_count") val forksCount: Int,
    @SerialName("open_issues_count") val openIssuesCount: Int,
    @SerialName("default_branch") val defaultBranch: String,
    val score: Double,
    @SerialName("archive_url") val archiveUrl: String,
    @SerialName("assignees_url") val assigneesUrl: String,
    @SerialName("blobs_url") val blobsUrl: String,
    @SerialName("branches_url") val branchesUrl: String,
    @SerialName("collaborators_url") val collaboratorsUrl: String,
    @SerialName("comments_url") val commentsUrl: String,
    @SerialName("commits_url") val commitsUrl: String,
    @SerialName("compare_url") val compareUrl: String,
    @SerialName("contents_url") val contentsUrl: String,
    @SerialName("contributors_url") val contributorsUrl: String,
    @SerialName("deployments_url") val deploymentsUrl: String,
    @SerialName("downloads_url") val downloadsUrl: String,
    @SerialName("events_url") val eventsUrl: String,
    @SerialName("forks_url") val forksUrl: String,
    @SerialName("git_commits_url") val gitCommitsUrl: String,
    @SerialName("git_refs_url") val gitRefsUrl: String,
    @SerialName("git_tags_url") val gitTagsUrl: String,
    @SerialName("git_url") val gitUrl: String,
    @SerialName("issue_comment_url") val issueCommentUrl: String,
    @SerialName("issue_events_url") val issueEventsUrl: String,
    @SerialName("issues_url") val issuesUrl: String,
    @SerialName("keys_url") val keysUrl: String,
    @SerialName("labels_url") val labelsUrl: String,
    @SerialName("languages_url") val languagesUrl: String,
    @SerialName("merges_url") val mergesUrl: String,
    @SerialName("milestones_url") val milestonesUrl: String,
    @SerialName("notifications_url") val notificationsUrl: String,
    @SerialName("pulls_url") val pullsUrl: String,
    @SerialName("releases_url") val releasesUrl: String,
    @SerialName("ssh_url") val sshUrl: String,
    @SerialName("stargazers_url") val stargazersUrl: String,
    @SerialName("statuses_url") val statusesUrl: String,
    @SerialName("subscribers_url") val subscribersUrl: String,
    @SerialName("subscription_url") val subscriptionUrl: String,
    @SerialName("tags_url") val tagsUrl: String,
    @SerialName("teams_url") val teamsUrl: String,
    @SerialName("trees_url") val treesUrl: String,
    @SerialName("clone_url") val cloneUrl: String,
    @SerialName("mirror_url") val mirrorUrl: String?,
    @SerialName("hooks_url") val hooksUrl: String,
    @SerialName("svn_url") val svnUrl: String,
    val forks: Int,
    @SerialName("open_issues") val openIssues: Int,
    val watchers: Int,
    @SerialName("has_issues") val hasIssues: Boolean,
    @SerialName("has_projects") val hasProjects: Boolean,
    @SerialName("has_pages") val hasPages: Boolean,
    @SerialName("has_wiki") val hasWiki: Boolean,
    @SerialName("has_downloads") val hasDownloads: Boolean,
    val archived: Boolean,
    val disabled: Boolean,
    val topics: List<String>,
    val visibility: String,
    val license: LicenseApiModel?
)