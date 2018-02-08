function constructionCrew(workerObj) {
    if (workerObj.handsShaking) {
        workerObj.bloodAlcoholLevel = workerObj.bloodAlcoholLevel + 0.1 * workerObj.experience * workerObj.weight;
        workerObj.handsShaking = false;
    }

    return workerObj;
}