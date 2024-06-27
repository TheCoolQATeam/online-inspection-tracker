export type CommonObj = {
    [key: string]: string;
}

export interface CaseBaseInfo {
    id?: string
    title?: string;
    groupId: number;
    url?: string;
    htmlinfo?: string;
    username?: string
    dingKey?: string
    wechatKey?: string
    feishuKey?: string
    needLogin: number
}

export interface TestPlan {
    id: string
    passedNum: number;
    skippedNum: number;
    totalNum: number;
    duration: number;
    beginTime?: string;
}
  