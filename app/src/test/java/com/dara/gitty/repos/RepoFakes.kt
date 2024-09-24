package com.dara.gitty.repos

import com.dara.gitty.repos.data.Repository
import com.dara.gitty.repos.data.model.LicenseApiModel
import com.dara.gitty.repos.data.model.OwnerApiModel
import com.dara.gitty.repos.data.model.RepositoriesResponseApiModel
import com.dara.gitty.repos.data.model.RepositoryApiModel

val repositoryApiModels = listOf(
    RepositoryApiModel(
        id = 666678739,
        nodeId = "R_kgDOJ7y10w",
        name = "WubbabooMark",
        fullName = "hfiref0x/WubbabooMark",
        isPrivate = false,
        owner = OwnerApiModel(
            "hfiref0x",
            10708977,
            "MDQ6VXNlcjEwNzA4OTc3",
            "https://avatars.githubusercontent.com/u/10708977?v=4",
            "https://api.github.com/users/hfiref0x",
            "https://github.com/hfiref0x",
            "https://api.github.com/users/hfiref0x/followers",
            "https://api.github.com/users/hfiref0x/following{/other_user}",
            "https://api.github.com/users/hfiref0x/gists{/gist_id}",
            "https://api.github.com/users/hfiref0x/starred{/owner}{/repo}",
            "https://api.github.com/users/hfiref0x/subscriptions",
            "https://api.github.com/users/hfiref0x/orgs",
            "https://api.github.com/users/hfiref0x/repos",
            "https://api.github.com/users/hfiref0x/events{/privacy}",
            "https://api.github.com/users/hfiref0x/received_events",
            "User",
            "",
            false
        ),
        htmlUrl = "https://github.com/hfiref0x/WubbabooMark",
        description = "Debugger Anti-Detection Benchmark",
        url = "https://api.github.com/repos/hfiref0x/WubbabooMark",
        forksUrl = "https://api.github.com/repos/hfiref0x/WubbabooMark/forks",
        keysUrl = "https://api.github.com/repos/hfiref0x/WubbabooMark/keys{/key_id}",
        collaboratorsUrl = "https://api.github.com/repos/hfiref0x/WubbabooMark/collaborators{/collaborator}",
        teamsUrl = "https://api.github.com/repos/hfiref0x/WubbabooMark/teams",
        hooksUrl = "https://api.github.com/repos/hfiref0x/WubbabooMark/hooks",
        issueEventsUrl = "https://api.github.com/repos/hfiref0x/WubbabooMark/issues/events{/number}",
        eventsUrl = "https://api.github.com/repos/hfiref0x/WubbabooMark/events",
        assigneesUrl = "https://api.github.com/repos/hfiref0x/WubbabooMark/assignees{/user}",
        branchesUrl = "https://api.github.com/repos/hfiref0x/WubbabooMark/branches{/branch}",
        tagsUrl = "https://api.github.com/repos/hfiref0x/WubbabooMark/tags",
        blobsUrl = "https://api.github.com/repos/hfiref0x/WubbabooMark/git/blobs{/sha}",
        gitTagsUrl = "https://api.github.com/repos/hfiref0x/WubbabooMark/git/tags{/sha}",
        gitRefsUrl = "https://api.github.com/repos/hfiref0x/WubbabooMark/git/refs{/sha}",
        treesUrl = "https://api.github.com/repos/hfiref0x/WubbabooMark/git/trees{/sha}",
        statusesUrl = "https://api.github.com/repos/hfiref0x/WubbabooMark/statuses/{sha}",
        languagesUrl = "https://api.github.com/repos/hfiref0x/WubbabooMark/languages",
        stargazersUrl = "https://api.github.com/repos/hfiref0x/WubbabooMark/stargazers",
        contributorsUrl = "https://api.github.com/repos/hfiref0x/WubbabooMark/contributors",
        subscribersUrl = "https://api.github.com/repos/hfiref0x/WubbabooMark/subscribers",
        subscriptionUrl = "https://api.github.com/repos/hfiref0x/WubbabooMark/subscription",
        commitsUrl = "https://api.github.com/repos/hfiref0x/WubbabooMark/commits{/sha}",
        gitCommitsUrl = "https://api.github.com/repos/hfiref0x/WubbabooMark/git/commits{/sha}",
        commentsUrl = "https://api.github.com/repos/hfiref0x/WubbabooMark/comments{/number}",
        issueCommentUrl = "https://api.github.com/repos/hfiref0x/WubbabooMark/issues/comments{/number}",
        contentsUrl = "https://api.github.com/repos/hfiref0x/WubbabooMark/contents/{+path}",
        compareUrl = "https://api.github.com/repos/hfiref0x/WubbabooMark/compare/{base}...{head}",
        mergesUrl = "https://api.github.com/repos/hfiref0x/WubbabooMark/merges",
        archiveUrl = "https://api.github.com/repos/hfiref0x/WubbabooMark/{archive_format}{/ref}",
        downloadsUrl = "https://api.github.com/repos/hfiref0x/WubbabooMark/downloads",
        issuesUrl = "https://api.github.com/repos/hfiref0x/WubbabooMark/issues{/number}",
        pullsUrl = "https://api.github.com/repos/hfiref0x/WubbabooMark/pulls{/number}",
        milestonesUrl = "https://api.github.com/repos/hfiref0x/WubbabooMark/milestones{/number}",
        notificationsUrl = "https://api.github.com/repos/hfiref0x/WubbabooMark/notifications{?since,all,participating}",
        labelsUrl = "https://api.github.com/repos/hfiref0x/WubbabooMark/labels{/name}",
        releasesUrl = "https://api.github.com/repos/hfiref0x/WubbabooMark/releases{/id}",
        deploymentsUrl = "https://api.github.com/repos/hfiref0x/WubbabooMark/deployments",
        createdAt = "2023-07-15T07:55:07Z",
        updatedAt = "2024-07-22T13:04:58Z",
        pushedAt = "2023-12-03T03:15:17Z",
        gitUrl = "git://github.com/hfiref0x/WubbabooMark.git",
        sshUrl = "git@github.com:hfiref0x/WubbabooMark.git",
        cloneUrl = "https://github.com/hfiref0x/WubbabooMark.git",
        svnUrl = "https://github.com/hfiref0x/WubbabooMark",
        homepage = null,
        size = 718,
        stargazersCount = 275,
        watchersCount = 275,
        language = "C",
        hasIssues = true,
        hasProjects = false,
        hasDownloads = true,
        hasWiki = false,
        hasPages = false,
        forksCount = 39,
        openIssuesCount = 1,
        license = LicenseApiModel(
            "mit",
            "MIT License",
            "MIT",
            "https://api.github.com/licenses/mit",
            "MDc6TGljZW5zZTEz"
        ),
        visibility = "public",
        forks = 39,
        openIssues = 1,
        watchers = 275,
        defaultBranch = "master",
        archived = false,
        disabled = false,
        score = 1.0,
        fork = false,
        mirrorUrl = "",
        topics = listOf()
    )
)

val fakeReposResponse = RepositoriesResponseApiModel(
    incompleteResults = false,
    repositories = repositoryApiModels,
    totalCount = 2
)

val fakeEmptyReposResponse = RepositoriesResponseApiModel(
    incompleteResults = false,
    repositories = emptyList(),
    totalCount = 0
)

val fakeRepos = listOf(
    Repository(
        owner = "dynammicwebpaige",
        name = "addons",
        imageUrl = "",
        description = "",
        stars = 3,
        language = "Python",
        topics = listOf("Python", "Tensorflow"),
        visibility = "Public",
        updatedAt = "2023-07-15T07:55:07Z"
    ),
    Repository(
        owner = "JetBrains",
        name = "kotlin",
        imageUrl = "",
        description = "The Kotlin programming language",
        stars = 48417,
        language = "Kotlin",
        topics = listOf("compiler", "gradle-plugin"),
        visibility = "Public",
        updatedAt = "2023-07-15T07:55:07Z"
    ),
)
