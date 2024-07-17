# SurveyMonkey Set up Guide 

This page guides you through the process of setting up a source connector in Airbyte for SurveyMonkey.


>[!NOTE]
OAuth for SurveyMonkey is officially supported only for the US. Airbyte is in the process of testing OAuth in the EU. [Contact us](mailto:product@airbyte.io) for further details.

> [!IMPORTANT]
**Performance considerations**
The SurveyMonkey API applies heavy API quotas for default private apps, with the following limits:
> - 125 requests per minute
> - 500 requests per day
>   
> To add additional requests from this source, you can use the [caching](https://docs.airbyte.com/connector-development/testing-connectors/connector-acceptance-tests-reference/#caching) feature.


## Prerequisites
<!-- This list assumes that the prerequsites are the same for both Open Source and Airbyte Cloud. IF different, we will need to have 2 sections here as well and move it onto the respective sections below as H2. -->

- Read the [Getting Started Documentation](https://developer.surveymonkey.com/api/v3/#getting-started)
- Register your application [here](https://developer.surveymonkey.com/apps/)
- [Obtain an access token](https://docs.airbyte.com/enterprise-setup/api-access-config#step-2-obtain-an-access-token)

<!-- /env:oss -->
## Process Using Open Source
### Step 1: Read and ensure that you have addressed the items listed in the _Prerequisites_ section above.

### Step 2: Set up the source connector in Airbyte
1. Go to your local Airbyte page. <!-- Where is this described? -->
2. In the left navigation bar, click **Sources**.
3. In the top-right corner, click **+New Source**.
4. On the source setup page, select **SurveyMonkey** from the Source type dropdown and enter a name for this connector.
5. In the **Access Token** field, add the "client_id": "", "client_secret": "" and ensure that it is valid. <!-- Is this the format? -->
6. Choose the required **Start Date**.
7. Click **Set up Source**.
<!-- What happens next? How can you tell if this process is complete and successful? -->

<!-- env:cloud -->

## Process Using Airbyte Cloud
### Step 1: Read and ensure that you have addressed the items listed in the _Prerequisites_ section above.

### Step 2: Set up the source connector in Airbyte
1. [Log into your Airbyte Cloud](https://cloud.airbyte.com/workspaces) account.
2. In the left navigation bar, click **Sources**.
3. In the top-right corner, click **+New Source**.
4. On the source setup page, select **SurveyMonkey** from the Source type dropdown and enter a name for this connector.
5. Click **Authenticate Your Account**.
6. Log in and Authorize the SurveyMonkey account. <!-- Where is this described? -->
7. Choose the required **Start Date**.
8. Click **Set up Source**.
<!-- What happens next? How can you tell if this process is complete and successful? -->


## Supported streams and sync modes
Once you have setup your source connector, you can perform the following taks:

- [Get Surveys](https://api.surveymonkey.com/v3/docs?shell#api-endpoints-get-surveys) \(Incremental\)
- [Get SurveyPages](https://api.surveymonkey.com/v3/docs?shell#api-endpoints-get-surveys-survey_id-pages)
- [Get SurveyQuestions](https://api.surveymonkey.com/v3/docs?shell#api-endpoints-get-surveys-survey_id-pages-page_id-questions)
- [Get SurveyResponses](https://api.surveymonkey.com/v3/docs?shell#api-endpoints-get-surveys-id-responses-bulk) \(Incremental\)
- [Get SurveyCollectors](https://api.surveymonkey.com/v3/docs?shell#api-endpoints-get-surveys-survey_id-collectors)
- [Get Collectors](https://api.surveymonkey.com/v3/docs?shell#api-endpoints-get-collectors-collector_id-)


## Changelog

<details>
  <summary>Expand to review</summary>

| Version | Date       | Pull Request                                             | Subject                                                                          |
| :------ | :--------- | :------------------------------------------------------- | :------------------------------------------------------------------------------- |
| 0.3.12 | 2024-07-13 | [41701](https://github.com/airbytehq/airbyte/pull/41701) | Update dependencies |
| 0.3.11 | 2024-07-10 | [41352](https://github.com/airbytehq/airbyte/pull/41352) | Update dependencies |
| 0.3.10 | 2024-07-09 | [41258](https://github.com/airbytehq/airbyte/pull/41258) | Update dependencies |
| 0.3.9 | 2024-07-06 | [40958](https://github.com/airbytehq/airbyte/pull/40958) | Update dependencies |
| 0.3.8 | 2024-06-26 | [40549](https://github.com/airbytehq/airbyte/pull/40549) | Migrate off deprecated auth package |
| 0.3.7 | 2024-06-25 | [40298](https://github.com/airbytehq/airbyte/pull/40298) | Update dependencies |
| 0.3.6 | 2024-06-22 | [40031](https://github.com/airbytehq/airbyte/pull/40031) | Update dependencies |
| 0.3.5 | 2024-06-07 | [39329](https://github.com/airbytehq/airbyte/pull/39329) | Add `CheckpointMixin` for state management |
| 0.3.4 | 2024-06-06 | [39244](https://github.com/airbytehq/airbyte/pull/39244) | [autopull] Upgrade base image to v1.2.2 |
| 0.3.3 | 2024-05-22 | [38559](https://github.com/airbytehq/airbyte/pull/38559) | Migrate Python stream authenticator to `requests_native_auth` package |
| 0.3.2 | 2024-05-20 | [38244](https://github.com/airbytehq/airbyte/pull/38244) | Replace AirbyteLogger with logging.Logger and upgrade base image |
| 0.3.1 | 2024-04-24 | [36664](https://github.com/airbytehq/airbyte/pull/36664) | Schema descriptions and CDK 0.80.0 |
| 0.3.0 | 2024-02-22 | [35561](https://github.com/airbytehq/airbyte/pull/35561) | Migrate connector to low-code |
| 0.2.4 | 2024-02-12 | [35168](https://github.com/airbytehq/airbyte/pull/35168) | Manage dependencies with Poetry |
| 0.2.3 | 2023-10-19 | [31599](https://github.com/airbytehq/airbyte/pull/31599) | Base image migration: remove Dockerfile and use the python-connector-base image |
| 0.2.2 | 2023-05-12 | [26024](https://github.com/airbytehq/airbyte/pull/26024) | Fix dependencies conflict |
| 0.2.1 | 2023-04-27 | [25109](https://github.com/airbytehq/airbyte/pull/25109) | Fix add missing params to stream `SurveyResponses` |
| 0.2.0 | 2023-04-18 | [23721](https://github.com/airbytehq/airbyte/pull/23721) | Add `SurveyCollectors` and `Collectors` stream |
| 0.1.16 | 2023-04-13 | [25080](https://github.com/airbytehq/airbyte/pull/25080) | Fix spec.json required fields and update schema for surveys and survey_responses |
| 0.1.15 | 2023-02-11 | [22865](https://github.com/airbytehq/airbyte/pull/22865) | Specified date formatting in specification |
| 0.1.14 | 2023-01-27 | [22024](https://github.com/airbytehq/airbyte/pull/22024) | Set `AvailabilityStrategy` for streams explicitly to `None` |
| 0.1.13 | 2022-11-29 | [19868](https://github.com/airbytehq/airbyte/pull/19868) | Fix OAuth flow urls |
| 0.1.12 | 2022-10-13 | [17964](https://github.com/airbytehq/airbyte/pull/17964) | Add OAuth for Eu and Ca |
| 0.1.11 | 2022-09-28 | [17326](https://github.com/airbytehq/airbyte/pull/17326) | Migrate to per-stream states |
| 0.1.10 | 2022-09-14 | [16706](https://github.com/airbytehq/airbyte/pull/16706) | Fix 404 error when handling nonexistent surveys |
| 0.1.9   | 2022-07-28 | [13046](https://github.com/airbytehq/airbyte/pull/14998) | Fix state for response stream, fixed backoff behaviour, added unittest           |
| 0.1.8   | 2022-05-20 | [13046](https://github.com/airbytehq/airbyte/pull/13046) | Fix incremental streams                                                          |
| 0.1.7   | 2022-02-24 | [8768](https://github.com/airbytehq/airbyte/pull/8768)   | Add custom survey IDs to limit API calls                                         |
| 0.1.6   | 2022-01-14 | [9508](https://github.com/airbytehq/airbyte/pull/9508)   | Scopes change                                                                    |
| 0.1.5   | 2021-12-28 | [8628](https://github.com/airbytehq/airbyte/pull/8628)   | Update fields in source-connectors specifications                                |
| 0.1.4   | 2021-11-11 | [7868](https://github.com/airbytehq/airbyte/pull/7868)   | Improve 'check' using '/users/me' API call                                       |
| 0.1.3   | 2021-11-01 | [7433](https://github.com/airbytehq/airbyte/pull/7433)   | Remove unsused oAuth flow parameters                                             |
| 0.1.2   | 2021-10-27 | [7433](https://github.com/airbytehq/airbyte/pull/7433)   | Add OAuth support                                                                |
| 0.1.1   | 2021-09-10 | [5983](https://github.com/airbytehq/airbyte/pull/5983)   | Fix caching for gzip compressed http response                                    |
| 0.1.0   | 2021-07-06 | [4097](https://github.com/airbytehq/airbyte/pull/4097)   | Initial Release                                                                  |

</details>
