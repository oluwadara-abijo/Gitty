package com.dara.gitty.users

import com.dara.gitty.repos.data.model.LicenseApiModel
import com.dara.gitty.repos.data.model.OwnerApiModel
import com.dara.gitty.repos.data.model.RepositoryApiModel
import com.dara.gitty.users.data.model.User
import com.dara.gitty.users.data.model.UserApiModel
import com.dara.gitty.users.data.model.UserInfo
import com.dara.gitty.users.data.model.UserInfoApiModel
import com.dara.gitty.users.data.model.UsersResponseApiModel

val userApiModels = listOf(
    UserApiModel(
        login = "janedoe",
        id = 12345,
        nodeId = "MDQ6VXNlcjEyMzQ1",
        avatarUrl = "https://example.com/avatar.jpg",
        gravatarId = "",
        url = "https://api.github.com/users/janedoe",
        htmlUrl = "https://github.com/janedoe",
        followersUrl = "https://api.github.com/users/janedoe/followers",
        followingUrl = "https://api.github.com/users/janedoe/following",
        gistsUrl = "https://api.github.com/users/janedoe/gists",
        starredUrl = "https://api.github.com/users/janedoe/starred",
        subscriptionsUrl = "https://api.github.com/users/janedoe/subscriptions",
        organizationsUrl = "https://api.github.com/users/janedoe/orgs",
        reposUrl = "https://api.github.com/users/janedoe/repos",
        eventsUrl = "https://api.github.com/users/janedoe/events",
        receivedEventsUrl = "https://api.github.com/users/janedoe/received_events",
        type = "User",
        siteAdmin = false,
        score = 1.0
    )
)

val userInfoApiModels = listOf(
    UserInfoApiModel(
        avatarUrl = "https://example.com/avatar.jpg",
        bio = "Software developer with a passion for open-source",
        blog = "https://myblog.com",
        company = "Example Corp",
        createdAt = "2012-01-01T12:00:00Z",
        email = "user@example.com",
        eventsUrl = "https://api.example.com/users/user/events",
        followers = 150,
        followersUrl = "https://api.example.com/users/user/followers",
        following = 100,
        followingUrl = "https://api.example.com/users/user/following",
        gistsUrl = "https://api.example.com/users/user/gists",
        gravatarId = "",
        hireable = true,
        htmlUrl = "https://github.com/user",
        id = 123456,
        location = "New York, USA",
        login = "user",
        name = "John Doe",
        nodeId = "MDQ6VXNlcjEyMzQ1Ng==",
        organizationsUrl = "https://api.example.com/users/user/orgs",
        publicGists = 10,
        publicRepos = 25,
        receivedEventsUrl = "https://api.example.com/users/user/received_events",
        reposUrl = "https://api.example.com/users/user/repos",
        siteAdmin = false,
        starredUrl = "https://api.example.com/users/user/starred",
        subscriptionsUrl = "https://api.example.com/users/user/subscriptions",
        twitterUsername = "johndoe",
        type = "User",
        updatedAt = "2023-01-01T12:00:00Z",
        url = "https://api.example.com/users/user"
    )
)

val fakeUsersResponse = UsersResponseApiModel(
    totalCount = 1,
    incompleteResults = false,
    users = userApiModels
)

val fakeEmptyUsersResponse = UsersResponseApiModel(
    totalCount = 0,
    incompleteResults = false,
    users = emptyList()
)

val fakeUserRepos = listOf(
    RepositoryApiModel(
        id = 123456,
        nodeId = "MDEwOlJlcG9zaXRvcnkxMjM0NTY=",
        name = "CoolProject",
        fullName = "janedoe/CoolProject",
        owner = OwnerApiModel(
            login = "janedoe",
            id = 654321,
            nodeId = "MDQ6VXNlcjY1NDMyMQ==",
            avatarUrl = "https://example.com/avatar.jpg",
            gravatarId = "",
            url = "https://api.github.com/users/janedoe",
            htmlUrl = "https://github.com/janedoe",
            followersUrl = "https://api.github.com/users/janedoe/followers",
            followingUrl = "https://api.github.com/users/janedoe/following{/other_user}",
            gistsUrl = "https://api.github.com/users/janedoe/gists{/gist_id}",
            starredUrl = "https://api.github.com/users/janedoe/starred{/owner}{/repo}",
            subscriptionsUrl = "https://api.github.com/users/janedoe/subscriptions",
            organizationsUrl = "https://api.github.com/users/janedoe/orgs",
            reposUrl = "https://api.github.com/users/janedoe/repos",
            eventsUrl = "https://api.github.com/users/janedoe/events{/privacy}",
            receivedEventsUrl = "https://api.github.com/users/janedoe/received_events",
            type = "User",
            siteAdmin = false
        ),
        isPrivate = false,
        htmlUrl = "https://github.com/janedoe/CoolProject",
        description = "This is a cool project created by Jane Doe.",
        fork = false,
        url = "https://api.github.com/repos/janedoe/CoolProject",
        createdAt = "2023-01-01T12:00:00Z",
        updatedAt = "2023-01-10T12:00:00Z",
        pushedAt = "2023-01-15T12:00:00Z",
        homepage = "https://coolproject.com",
        size = 1024,
        stargazersCount = 150,
        watchersCount = 150,
        language = "Kotlin",
        forksCount = 20,
        openIssuesCount = 5,
        defaultBranch = "main",
        score = 1.0,
        archiveUrl = "https://api.github.com/repos/janedoe/CoolProject/{archive_format}{/ref}",
        assigneesUrl = "https://api.github.com/repos/janedoe/CoolProject/assignees{/user}",
        blobsUrl = "https://api.github.com/repos/janedoe/CoolProject/git/blobs{/sha}",
        branchesUrl = "https://api.github.com/repos/janedoe/CoolProject/branches{/branch}",
        collaboratorsUrl = "https://api.github.com/repos/janedoe/CoolProject/collaborators{/collaborator}",
        commentsUrl = "https://api.github.com/repos/janedoe/CoolProject/comments{/number}",
        commitsUrl = "https://api.github.com/repos/janedoe/CoolProject/commits{/sha}",
        compareUrl = "https://api.github.com/repos/janedoe/CoolProject/compare/{base}...{head}",
        contentsUrl = "https://api.github.com/repos/janedoe/CoolProject/contents/{+path}",
        contributorsUrl = "https://api.github.com/repos/janedoe/CoolProject/contributors",
        deploymentsUrl = "https://api.github.com/repos/janedoe/CoolProject/deployments",
        downloadsUrl = "https://api.github.com/repos/janedoe/CoolProject/downloads",
        eventsUrl = "https://api.github.com/repos/janedoe/CoolProject/events",
        forksUrl = "https://api.github.com/repos/janedoe/CoolProject/forks",
        gitCommitsUrl = "https://api.github.com/repos/janedoe/CoolProject/git/commits{/sha}",
        gitRefsUrl = "https://api.github.com/repos/janedoe/CoolProject/git/refs{/sha}",
        gitTagsUrl = "https://api.github.com/repos/janedoe/CoolProject/git/tags{/sha}",
        gitUrl = "git://github.com/janedoe/CoolProject.git",
        issueCommentUrl = "https://api.github.com/repos/janedoe/CoolProject/issues/comments{/number}",
        issueEventsUrl = "https://api.github.com/repos/janedoe/CoolProject/issues/events{/number}",
        issuesUrl = "https://api.github.com/repos/janedoe/CoolProject/issues{/number}",
        keysUrl = "https://api.github.com/repos/janedoe/CoolProject/keys{/key_id}",
        labelsUrl = "https://api.github.com/repos/janedoe/CoolProject/labels{/name}",
        languagesUrl = "https://api.github.com/repos/janedoe/CoolProject/languages",
        mergesUrl = "https://api.github.com/repos/janedoe/CoolProject/merges",
        milestonesUrl = "https://api.github.com/repos/janedoe/CoolProject/milestones{/number}",
        notificationsUrl = "https://api.github.com/repos/janedoe/CoolProject/notifications{?since,all,participating}",
        pullsUrl = "https://api.github.com/repos/janedoe/CoolProject/pulls{/number}",
        releasesUrl = "https://api.github.com/repos/janedoe/CoolProject/releases{/id}",
        sshUrl = "git@github.com:janedoe/CoolProject.git",
        stargazersUrl = "https://api.github.com/repos/janedoe/CoolProject/stargazers",
        statusesUrl = "https://api.github.com/repos/janedoe/CoolProject/statuses/{sha}",
        subscribersUrl = "https://api.github.com/repos/janedoe/CoolProject/subscribers",
        subscriptionUrl = "https://api.github.com/repos/janedoe/CoolProject/subscription",
        tagsUrl = "https://api.github.com/repos/janedoe/CoolProject/tags",
        teamsUrl = "https://api.github.com/repos/janedoe/CoolProject/teams",
        treesUrl = "https://api.github.com/repos/janedoe/CoolProject/git/trees{/sha}",
        cloneUrl = "https://github.com/janedoe/CoolProject.git",
        mirrorUrl = null,
        hooksUrl = "https://api.github.com/repos/janedoe/CoolProject/hooks",
        svnUrl = "https://github.com/janedoe/CoolProject",
        forks = 20,
        openIssues = 5,
        watchers = 150,
        hasIssues = true,
        hasProjects = true,
        hasPages = false,
        hasWiki = true,
        hasDownloads = true,
        archived = false,
        disabled = false,
        topics = listOf("kotlin", "android", "opensource"),
        visibility = "public",
        license = LicenseApiModel(
            key = "mit",
            name = "MIT License",
            spdxId = "MIT",
            url = "https://api.github.com/licenses/mit",
            nodeId = "MDc6TGljZW5zZW1pdA=="
        )
    )
)

val fakeUsers = listOf(
    User(
        name = "John Doe",
        id = 101,
        avatarUrl = "https://example.com/avatar/johndoe.jpg",
        url = "https://example.com/users/johndoe"
    ),
    User(
        name = "Jane Smith",
        id = 202,
        avatarUrl = "https://example.com/avatar/janesmith.jpg",
        url = "https://example.com/users/janesmith"
    )
)
